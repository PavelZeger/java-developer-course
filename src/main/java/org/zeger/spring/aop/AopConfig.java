package org.zeger.spring.aop;

import org.springframework.context.annotation.*;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
@EnableAspectJAutoProxy
public class AopConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AppService appService = context.getBean(AppService.class);
        appService.execute();
    }

}
