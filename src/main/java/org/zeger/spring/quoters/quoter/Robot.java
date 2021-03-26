package org.zeger.spring.quoters.quoter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
@Data
@Component
public class Robot implements TalkingRobot {

    @Autowired
    private List<Quoter> quoters;

    @Override
    @EventListener(ContextRefreshedEvent.class)
    public void talk() {
        quoters.forEach(Quoter::sayQuote);
    }

}
