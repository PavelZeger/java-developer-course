package org.zeger.spring.qualifier;

import lombok.SneakyThrows;
import org.zeger.spring.qualifier.annotation.DBRepository;

import static org.zeger.spring.qualifier.DBType.MONGODB;

/**
    @author Pavel Zeger
    @since 28/03/2021
    @implNote java-developer-course
*/
@DBRepository(MONGODB)
public class MongoDao implements Dao {

    @Override
    @SneakyThrows
    public void saveAll() {
        Thread.sleep(10);
        System.out.println("Saved to Mongo");
    }

}
