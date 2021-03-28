package org.zeger.spring.quoters.quoter;

import org.springframework.beans.factory.annotation.Value;
import org.zeger.customspring.factory.annotation.InjectRandomInt;
import org.zeger.spring.quoters.annotation.Book;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
@Book
public class ShakespeareQuoter implements Quoter {

    @InjectRandomInt(min = 3, max = 5)
    private int repeat;

    @Value("${shakespeare}")
    private String message;

    @Override
    public void sayQuote() {
        for (int i = 0; i < repeat; i++) {
            System.out.println(message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}