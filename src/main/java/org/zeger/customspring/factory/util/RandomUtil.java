package org.zeger.customspring.factory.util;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
@Getter
@Setter
public class RandomUtil {

    private static Random random = new Random();

    private RandomUtil() {
    }

    public static int getRandomInt(int min, int max) {
       return random.nextInt(max - min) + min;
    }

}
