package org.zeger.spring.aop.aspect;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.zeger.spring.aop.exception.DatabaseRuntimeException;

import java.util.Arrays;
import java.util.List;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Aspect
@AllArgsConstructor
@Getter
public class ExceptionHandlerAspect {

    private List<String> emails;

    public void setEmails(@Value("${emails}") String emails) {
        this.emails = Arrays.asList(emails.split(","));
    }

    @Pointcut("execution(* org.zeger.spring.aop..*.*(..))")
    public void allMethods() {

    }

    @AfterThrowing(pointcut = "allMethods()", throwing = "databaseRuntimeException")
    public void dbException(DatabaseRuntimeException databaseRuntimeException) {
        emails.forEach(System.out::println);
    }
}
