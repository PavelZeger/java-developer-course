package org.zeger.customspring.factory.config.proxy;

import lombok.SneakyThrows;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.InvocationHandler;
import org.zeger.customspring.benchmark.BenchmarkToggle;
import org.zeger.customspring.factory.annotation.Benchmark;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {

    private final BenchmarkToggle benchmarkToggle = new BenchmarkToggle();

    @Override
    public <T> Object wrapWithProxy(Object object, Class<T> type) {
        if (type.isAnnotationPresent(Benchmark.class)|| Arrays.stream(type.getMethods()).anyMatch(method -> method.isAnnotationPresent(Benchmark.class))) {
            if (type.getInterfaces().length == 0) {
                return Enhancer.create(type, (InvocationHandler) (o, method, args) -> getInvocationHandlerLogic(object, type, method, args));
            }
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), (proxy, method, args) -> getInvocationHandlerLogic(object, type, method, args));
        }
        return type;
    }

    @SneakyThrows
    private <T> Object getInvocationHandlerLogic(Object t, Class<T> type, Method method, Object[] args) {
        Method classMethod = type.getMethod(method.getName(), method.getParameterTypes());
        if (benchmarkToggle.isEnabled() && (type.isAnnotationPresent(Benchmark.class) || classMethod.isAnnotationPresent(Benchmark.class))) {
            System.out.println("*** Benchmark for the method " + method.getName() + " started ***");
            long start = System.nanoTime();
            Object value = method.invoke(type, args);
            long end = System.nanoTime();
            System.out.println(end - start);
            System.out.println("*** Benchmark for the method " + method.getName() + " finished ***");
            return value;
        } else {
            return method.invoke(t, args);
        }
    }

}
