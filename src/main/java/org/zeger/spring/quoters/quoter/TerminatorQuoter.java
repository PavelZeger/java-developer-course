package org.zeger.spring.quoters.quoter;

import org.springframework.beans.factory.annotation.Value;
import org.zeger.spring.quoters.annotation.Book;
import org.zeger.spring.quoters.annotation.DeprecatedClass;
import org.zeger.spring.quoters.annotation.Film;

import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
@Book
@Film
@DeprecatedClass(newClass = T1000.class)
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Value("${terminator}")
    public void setMessages(String[] messages,@Value("${m2_home}") String javaHome) {
        System.out.println("javaHome = " + javaHome);
        this.messages = new ArrayList<>(Arrays.asList(messages));
    }

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }

    @PreDestroy
    public void killAll(){
        new Thread(() -> System.out.println("You are terminated")).start();
    }

    public void setMessage(List message) {
    }
}
