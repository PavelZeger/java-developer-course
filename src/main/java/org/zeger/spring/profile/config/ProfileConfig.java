package org.zeger.spring.profile.config;

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
public class ProfileConfig {

    public static void main(String[] args) {
        // For the demonstration only:
        System.setProperty("spring.profiles.active", "DEV");
        new AnnotationConfigApplicationContext(ProfileConfig.class);
    }
}
