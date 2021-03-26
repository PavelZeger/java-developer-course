package org.zeger.customspring;

import org.zeger.customspring.factory.ObjectFactory;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class App {

    public static void main(String[] args) {
        ObjectFactory.getInstance().createObject(IRobot.class).cleanRoom();
    }
}
