package org.zeger.spring.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import static org.zeger.spring.profile.config.Constant.PROD;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Repository
@Profile(PROD)
public class ProdRepo implements Repo {

    @Override
    public void crud() {
        System.out.println("Saving to PROD");
    }

}
