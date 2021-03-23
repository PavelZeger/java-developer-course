package org.zeger.customspring;

import org.zeger.customspring.factory.ObjectFactory;
import org.zeger.customspring.cleaner.Cleaner;
import org.zeger.customspring.speaker.Speaker;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class IRobot {

    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);

    public void cleanRoom() {
        speaker.speak("I've started...");
        cleaner.clean();
        speaker.speak("I've finished...");
    }

}
