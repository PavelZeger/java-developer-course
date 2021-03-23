package org.zeger.customspring.factory;

import lombok.SneakyThrows;
import org.zeger.customspring.factory.annotation.InjectRandomInt;
import org.zeger.customspring.factory.config.Config;
import org.zeger.customspring.factory.config.JavaConfig;
import org.zeger.customspring.factory.util.RandomUtil;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class ObjectFactory {

    private static volatile ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    private ObjectFactory() {
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
        if (type.isInterface()) {
            type = config.getImplementation(type);
        }
        List<Field> annotatedFields = Arrays.stream(type.getDeclaredFields())
                .filter(field -> field.isAnnotationPresent(InjectRandomInt.class))
                .collect(Collectors.toUnmodifiableList());
        annotatedFields.forEach(field -> {
            field.setAccessible(true);
            field.set(RandomUtil.getRandomInt());
        });
        return type.getDeclaredConstructor().newInstance();
    }

}
