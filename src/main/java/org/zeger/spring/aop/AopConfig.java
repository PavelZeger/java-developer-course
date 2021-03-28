package org.zeger.spring.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Configuration
@ComponentScan
public class AopConfig {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AopConfig.class);
    }

}
