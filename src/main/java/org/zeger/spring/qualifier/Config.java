package org.zeger.spring.qualifier;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Configuration
@ComponentScan
@EnableScheduling
public class Config {

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Config.class);
    }

}
