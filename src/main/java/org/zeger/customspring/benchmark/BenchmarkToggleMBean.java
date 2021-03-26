package org.zeger.customspring.benchmark;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public interface BenchmarkToggleMBean {

    boolean isEnabled();

    void setEnabled(boolean enabled);

    default void shutDown(int code) {
        System.out.println("code = " + code);
        System.exit(code);
    }

}