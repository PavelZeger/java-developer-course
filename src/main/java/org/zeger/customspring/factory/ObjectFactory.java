package org.zeger.customspring.factory;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.reflections.Reflections;
import org.zeger.customspring.exception.ImplementationException;
import org.zeger.customspring.factory.config.Config;
import org.zeger.customspring.factory.config.JavaConfig;
import org.zeger.customspring.factory.config.object.ObjectConfigurator;
import org.zeger.customspring.factory.config.proxy.ProxyConfigurator;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class ObjectFactory {

    private final Reflections scanner = new Reflections("org.zeger.customspring");
    private static ObjectFactory instance = new ObjectFactory();
    private final Config config = new JavaConfig();
    private final List<ObjectConfigurator> objectConfigurators = new ArrayList<>();
    private final List<ProxyConfigurator> proxyConfigurators = new ArrayList<>();

    @SneakyThrows
    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurator>> configuratorClasses = scanner.getSubTypesOf(ObjectConfigurator.class);
        Set<Class<? extends ProxyConfigurator>> proxyConfiguratorClasses = scanner.getSubTypesOf(ProxyConfigurator.class);
        initConfigurators(configuratorClasses, proxyConfiguratorClasses);
    }

    @SneakyThrows
    private void initConfigurators(Set<Class<? extends ObjectConfigurator>> configuratorClasses,
                                   Set<Class<? extends ProxyConfigurator>> proxyConfiguratorClasses) {
        for (Class<? extends ObjectConfigurator> configurator : configuratorClasses) {
            objectConfigurators.add(configurator.getDeclaredConstructor().newInstance());
        }
        for (Class<? extends ProxyConfigurator> configurator : proxyConfiguratorClasses) {
            proxyConfigurators.add(configurator.getDeclaredConstructor().newInstance());
        }
    }

    public static ObjectFactory getInstance() {
        ObjectFactory objectFactory = instance;
        if (objectFactory != null) {
            return objectFactory;
        }
        synchronized(ObjectFactory.class) {
            if (instance == null) {
                instance = new ObjectFactory();
            }
            return instance;
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        type = getImplementation(type);
        T object = create(type);
        configure(object);
        invokeInitMethod(object);
        object = wrapWithProxy(type, object);
        return object;
    }

    private <T> T wrapWithProxy(Class<T> type, T object) {
        for (ProxyConfigurator proxyConfigurator : proxyConfigurators) {
            object = (T) proxyConfigurator.wrapWithProxy(object, type);
        }
        return object;
    }

    @SneakyThrows
    private <T> void invokeInitMethod(T object) {
        Set<Method> annotatedMethods = ReflectionUtils.getAllMethods(object.getClass(), method -> method.isAnnotationPresent(PostConstruct.class))
                .stream().collect(Collectors.toUnmodifiableSet());
        for (Method method : annotatedMethods) {
            method.invoke(object);
        }
    }

    @SneakyThrows
    private <T> T create(Class<T> type) {
        return type.getDeclaredConstructor().newInstance();
    }

    private <T> void configure(T object) {
        objectConfigurators.forEach(configurator -> configurator.configure(object));
    }

    private <T> Class<T> getImplementation(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implementedClass = config.getImplementation(type);
            if (implementedClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new ImplementationException(
                            "0 or more than one implementation of the type" + type.getSimpleName() +
                            " was found, please update your configuration");
                }
                type = (Class<T>) classes.iterator().next();
            } else {
                type = implementedClass;
            }
        }
        return type;
    }


}
