package org.zeger.customspring.speaker;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class ConsoleSpeaker implements Speaker {

    @Override
    public void speak(String message) {
        System.out.println(message);
    }

}
