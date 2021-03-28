package org.zeger.spring.profile;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProfileConfig.class)
@ActiveProfiles("DEV")
public class MainServiceTest {

    @Autowired
    private MainService mainService;

    @Test
    public void testWork() {
        mainService.work();
    }

}