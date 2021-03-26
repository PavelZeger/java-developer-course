package org.zeger.spring.quoters.beanpostprocessor;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.annotation.PreDestroy;
import java.util.Arrays;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class BeanDefinitionAnalyzerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            boolean isPreDestroyMethodDefined = Arrays.stream(beanClass.getMethods()).anyMatch(method -> method.isAnnotationPresent(PreDestroy.class));
            if (beanDefinition.isPrototype() && (isPreDestroyMethodDefined || beanDefinition.getDestroyMethodName() != null)) {
                throw new IllegalStateException("Don't do it!");
            }

        }

    }
}
