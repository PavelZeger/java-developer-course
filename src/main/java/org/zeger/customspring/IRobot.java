package org.zeger.customspring;

import org.zeger.customspring.cleaner.Cleaner;
import org.zeger.customspring.factory.annotation.InjectByType;
import org.zeger.customspring.speaker.Speaker;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class IRobot {

    @InjectByType
    private Speaker speaker;

    @InjectByType
    private Cleaner cleaner;

    public void init() {

    }

    public void cleanRoom() {
        speaker.speak("I've started...");
        cleaner.clean();
        speaker.speak("I've finished...");
    }

}
