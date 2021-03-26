package org.zeger.customspring;

import org.zeger.customspring.factory.ObjectFactory;
import org.zeger.customspring.worker.Worker;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class App {

    public static void main(String[] args) {
        ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
        ObjectFactory.getInstance().createObject(Worker.class).rest();
    }

}
