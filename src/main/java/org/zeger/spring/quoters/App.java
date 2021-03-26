package org.zeger.spring.quoters;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.zeger.spring.quoters.config.Config;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        context.close();
    }
}
