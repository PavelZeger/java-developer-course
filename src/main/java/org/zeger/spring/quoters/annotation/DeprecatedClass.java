package org.zeger.spring.quoters.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 27/03/2021
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {

    Class<?> newClass();

}
