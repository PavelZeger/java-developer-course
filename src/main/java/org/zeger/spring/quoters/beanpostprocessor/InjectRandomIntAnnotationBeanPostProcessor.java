package org.zeger.spring.quoters.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.zeger.customspring.factory.config.object.InjectRandomIntAnnotationObjectConfigurator;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final InjectRandomIntAnnotationObjectConfigurator injectConfigurator = new InjectRandomIntAnnotationObjectConfigurator();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        injectConfigurator.configure(bean);
        return bean;
    }

}
