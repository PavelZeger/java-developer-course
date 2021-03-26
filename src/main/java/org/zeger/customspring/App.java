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
        IRobot iRobot = ObjectFactory.getInstance().createObject(IRobot.class);
        iRobot.cleanRoom();

        Worker worker = ObjectFactory.getInstance().createObject(Worker.class);
        worker.work();
        worker.rest();
    }

}
