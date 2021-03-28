package org.zeger.spring.qualifier;

import lombok.SneakyThrows;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.zeger.spring.qualifier.annotation.DBRepository;

import static org.zeger.spring.qualifier.DBType.MONGODB;
import static org.zeger.spring.qualifier.DBType.ORACLE;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Service
public class DatabaseService {

    @DBRepository(MONGODB)
    private Dao dao;

    @DBRepository(ORACLE)
    private Dao backupDao;

    @Scheduled(fixedDelay = 500)
    @SneakyThrows
    public void work(){
        dao.saveAll();
    }

    @Scheduled(fixedDelay = 3000)
    @SneakyThrows
    public void backup() {
        backupDao.saveAll();
    }

}
