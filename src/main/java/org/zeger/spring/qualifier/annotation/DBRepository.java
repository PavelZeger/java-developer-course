package org.zeger.spring.qualifier.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zeger.spring.qualifier.DBType;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
@Repository
@Autowired
public @interface DBRepository {

    DBType value();
}
