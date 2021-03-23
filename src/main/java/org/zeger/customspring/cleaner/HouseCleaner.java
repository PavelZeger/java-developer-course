package org.zeger.customspring.cleaner;

import lombok.Getter;
import lombok.Setter;
import org.zeger.customspring.factory.annotation.InjectRandomInt;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
@Getter
@Setter
public class HouseCleaner implements Cleaner {

    @InjectRandomInt(min = 3, max = 7)
    private int repeatTime;

    @Override
    public void clean() {
        for (int i = 0; i < repeatTime; i++) {
            System.out.println("I'm cleaning!..");
        }
    }

}
