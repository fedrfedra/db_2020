package my_spring;

import lombok.SneakyThrows;

import java.util.Map;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {

    private Config config = new ConfigMap();

//    private Map<Class, Class> ifc2ImplClass = Map.of(Speaker.class, ConsoleSpeaker.class)


    private static ObjectFactory objectFactory = new ObjectFactory();

    private ObjectFactory() {
    }

    public static ObjectFactory getInstance() {
        return objectFactory;
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            config.getImpl(type);
        }
        T t = type.getDeclaredConstructor().newInstance();
        return t;
        //todo finish this
        // if type is concrete class, just create and return it's instance
        //if type is and interface, you should find appropriative impl.
    }
}
