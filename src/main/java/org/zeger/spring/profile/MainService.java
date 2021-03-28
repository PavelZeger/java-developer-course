package org.zeger.spring.profile;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Service
@RequiredArgsConstructor
public class MainService {

    private final Repo repo;

    @Scheduled(fixedDelay = 1000)
    public void work() {
        repo.crud();
    }

}
