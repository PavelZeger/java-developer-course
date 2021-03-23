package org.zeger.customspring.factory.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {

    int max();
    int min();

}
