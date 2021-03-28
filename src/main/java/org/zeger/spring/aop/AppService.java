package org.zeger.spring.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zeger.spring.aop.dao.RedisDao;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Service
public class AppService {

    @Autowired
    private RedisDao redisDao;

    public void execute() {
        redisDao.saveData();
    }


}
