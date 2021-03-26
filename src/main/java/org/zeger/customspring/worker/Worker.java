package org.zeger.customspring.worker;

import org.zeger.customspring.factory.annotation.Benchmark;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class Worker {

    public void work() {
        System.out.println("The worker is working");
    }

    @Benchmark
    public void rest() {
        System.out.println("The worker is resting");
    }
}
