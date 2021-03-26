package org.zeger.customspring.worker;

import lombok.NoArgsConstructor;
import org.zeger.customspring.factory.annotation.Benchmark;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
@NoArgsConstructor
public class Worker {

    public void work() {
        System.out.println("The worker is working");
    }

    @Benchmark
    public void rest() {
        System.out.println("The worker is resting");
    }
}
