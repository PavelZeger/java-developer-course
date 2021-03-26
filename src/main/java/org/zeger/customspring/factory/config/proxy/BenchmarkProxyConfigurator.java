package org.zeger.customspring.factory.config.proxy;

import org.zeger.customspring.factory.annotation.Benchmark;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class BenchmarkProxyConfigurator implements ProxyConfigurator {

    @Override
    public <T> Object wrapWithProxy(Object object, Class<T> type) {
        if (type.isAnnotationPresent(Benchmark.class)) {
            return (T) Proxy.newProxyInstance(type.getClassLoader(), type.getInterfaces(), new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    System.out.println("*** Benchmark for the method " + method.getName() + " started ***");
                    long startTime = System.nanoTime();
                    Object value = method.invoke(object, args);
                    long endTime = System.nanoTime();
                    System.out.println("Benchmark time: " + (endTime - startTime));
                    System.out.println("*** Benchmark for the method " + method.getName() + " finished ***");
                    return value;
                }
            });
        }
        return object;
    }

}
