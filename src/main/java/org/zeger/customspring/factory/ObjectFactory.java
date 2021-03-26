package org.zeger.customspring.factory;

import lombok.SneakyThrows;
import org.reflections.Reflections;
import org.zeger.customspring.factory.config.Config;
import org.zeger.customspring.factory.config.JavaConfig;
import org.zeger.customspring.factory.config.ObjectConfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class ObjectFactory {

    private static ObjectFactory instance = new ObjectFactory();
    private final Config config = new JavaConfig();
    private final List<ObjectConfigurator> configurators = new ArrayList<>();

    @SneakyThrows
    private ObjectFactory() {
        Reflections scanner = new Reflections("org.zeger.customspring");
        Set<Class<? extends ObjectConfigurator>> configuratorClasses = scanner.getSubTypesOf(ObjectConfigurator.class);
        initConfigurators(configuratorClasses);
    }

    @SneakyThrows
    private void initConfigurators(Set<Class<? extends ObjectConfigurator>> configuratorClasses) {
        for (Class<? extends ObjectConfigurator> configurator : configuratorClasses) {
            configurators.add(configurator.getDeclaredConstructor().newInstance());
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
        T object = type.getDeclaredConstructor().newInstance();
        configure(object);
        return object;
    }

    private <T> void configure(T object) {
        configurators.forEach(configurator -> configurator.configure(object));
    }

    private <T> Class<T> getImplementation(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplementation(type);
        }
        return type;
    }


}
