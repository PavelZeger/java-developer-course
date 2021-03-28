package org.zeger.spring.aop.exception;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 28/03/2021
 */
public class DatabaseRuntimeException extends RuntimeException {

    public DatabaseRuntimeException(String message) {
        super(message);
    }

    public DatabaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

}
