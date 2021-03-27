package org.zeger.spring.quoters.beanpostprocessor;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.zeger.spring.quoters.annotation.DeprecatedClass;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 27/03/2021
 */
public class DeprecatedClassBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        String[] beanNames = configurableListableBeanFactory.getBeanDefinitionNames();
        for (String beanName :  beanNames) {
            BeanDefinition beanDefinition = configurableListableBeanFactory.getBeanDefinition(beanName);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
            if (beanClass.isAnnotationPresent(DeprecatedClass.class) && annotation != null) {
                String newClassName = annotation.newClass().getName();
                beanDefinition.setBeanClassName(newClassName);
            }
        }
    }
}
