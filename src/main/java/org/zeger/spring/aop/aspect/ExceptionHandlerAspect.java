package org.zeger.spring.aop.aspect;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.zeger.spring.aop.exception.DatabaseRuntimeException;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
@Aspect
public class ExceptionHandlerAspect {

    @Value("${emails}")
    private String[] emails;
    private Map<DatabaseRuntimeException, Void> exceptions = new WeakHashMap<>();

    @Pointcut("execution(* org.zeger.spring.aop..*.*(..))")
    public void allMethods() {
        System.out.println("Pointcut: execution(* org.zeger.spring.aop..*.*(..))");
    }

    @AfterThrowing(pointcut = "allMethods()", throwing = "databaseRuntimeException")
    public void dbException(DatabaseRuntimeException databaseRuntimeException) {
        if (!exceptions.containsKey(databaseRuntimeException)) {
            for (String email : emails) {
                System.out.println(email + ": " + databaseRuntimeException.getMessage());
            }
        }
    }
}
