package org.zeger.spring.aop.dao;

import org.springframework.stereotype.Repository;
import org.zeger.spring.aop.exception.DatabaseRuntimeException;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Repository
public class RedisDao implements Dao {

    @Override
    public void saveData() {
        System.out.println("Saving in REDIS");
        throw new DatabaseRuntimeException("The connection failed!");
    }

}
