package org.zeger.spring.quoters.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.zeger.customspring.factory.annotation.Benchmark;
import org.zeger.customspring.factory.config.proxy.BenchmarkProxyConfigurator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class BenchmarkBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class> beans = new HashMap<>();
    private final BenchmarkProxyConfigurator benchmarkProxyConfigurator = new BenchmarkProxyConfigurator();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean.getClass().isAnnotationPresent(Benchmark.class)) {
            beans.put(beanName, bean.getClass());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> type = beans.get(beanName);
        if (type != null) {
            return benchmarkProxyConfigurator.wrapWithProxy(type, bean);
        }
        return bean;
    }
}
