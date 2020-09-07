package my_spring;

import java.util.HashMap;

public class ConfigMap implements Config{

    private Map<Class, Class> ifc2ImplClass = Map.of(Speaker.class, ConsoleSpeaker.class);

    public ConfigMap() {
        ifc2ImplClass.put(Speaker.class, ConsoleSpeaker.class);
        ifc2ImplClass.put(Cleaner.class, CleanerImpl.class);
    }

    public <T> Class<T> getImpl(Class<T> type) {
        return ifc2ImplClass.get(type);
    }
}
