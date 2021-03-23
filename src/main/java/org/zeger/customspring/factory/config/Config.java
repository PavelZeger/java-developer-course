package org.zeger.customspring.factory.config;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public interface Config {

    <T> Class<T> getImplementation(Class<T> type);

}
