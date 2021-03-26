package org.zeger.customspring.factory.config;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;
import org.zeger.customspring.factory.annotation.InjectRandomInt;
import org.zeger.customspring.factory.util.RandomUtil;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 26/03/2021
 */
public class InjectRandomIntAnnotationObjectConfigurator implements ObjectConfigurator {

    @Override
    @SneakyThrows
    public void configure(Object object) {
        Set<Field> annotatedFields = ReflectionUtils.getAllFields(object.getClass(), field -> field.isAnnotationPresent(InjectRandomInt.class))
                .stream().collect(Collectors.toUnmodifiableSet());
        for (Field field : annotatedFields) {
            field.setAccessible(true);
            field.set(object, RandomUtil.getRandomInt(
                    field.getAnnotation(InjectRandomInt.class).min(),
                    field.getAnnotation(InjectRandomInt.class).max()));
        }
    }
}
