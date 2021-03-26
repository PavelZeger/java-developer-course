package org.zeger.customspring.factory.config.object;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.zeger.customspring.factory.ObjectFactory;
import org.zeger.customspring.factory.annotation.InjectByType;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class InjectByTypeAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object object) {
        Class<?> type = object.getClass();
        Set<Field> annotatedFields = ReflectionUtils.getAllFields(type, field -> field.isAnnotationPresent(InjectByType.class))
                .stream().collect(Collectors.toUnmodifiableSet());
        for (Field field : annotatedFields) {
            field.setAccessible(true);
            field.set(object, ObjectFactory.getInstance().createObject(field.getType()));
        }
    }
}
