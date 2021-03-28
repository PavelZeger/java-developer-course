package org.zeger.spring.quoters.quoter;

import java.util.List;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public interface TalkingRobot {

    void talk();

    void setQuoters(List quoters);
}
