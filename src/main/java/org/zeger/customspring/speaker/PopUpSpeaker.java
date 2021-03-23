package org.zeger.customspring.speaker;

import javax.swing.*;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class PopUpSpeaker implements Speaker {

    @Override
    public void speak(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}
