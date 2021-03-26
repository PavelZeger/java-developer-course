package org.zeger.customspring.factory.config.proxy;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public interface ProxyConfigurator {

    <T> Object wrapWithProxy(Object object, Class<T> type);

}