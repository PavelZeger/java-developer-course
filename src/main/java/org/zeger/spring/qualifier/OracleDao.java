package org.zeger.spring.qualifier;

import lombok.SneakyThrows;
import org.zeger.spring.qualifier.annotation.DBRepository;

import static org.zeger.spring.qualifier.DBType.ORACLE;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@DBRepository(ORACLE)
public class OracleDao implements Dao {

    @Override
    @SneakyThrows
    public void saveAll() {
        Thread.sleep(5);
        System.out.println("Saved to Oracle");
    }

}
