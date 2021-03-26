package org.zeger.customspring.factory.config;

import org.zeger.customspring.cleaner.Cleaner;
import org.zeger.customspring.cleaner.HouseCleaner;
import org.zeger.customspring.speaker.ConsoleSpeaker;
import org.zeger.customspring.speaker.Speaker;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Zeger
 * @implNote java-developer-course
 * @since 23/03/2021
 */
public class JavaConfig implements Config {

    private Map<Class, Class> interfaceToImplementation = new HashMap<>();

    public JavaConfig() {
        interfaceToImplementation.put(Speaker.class, ConsoleSpeaker.class);
        interfaceToImplementation.put(Cleaner.class, HouseCleaner.class);
    }

    @Override
    public <T> Class<T> getImplementation(Class<T> type) {
        return interfaceToImplementation.get(type);
    }

}
