package real_spring.aop_advanced.services;

import lombok.SneakyThrows;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PostProxyConstructAnnotation implements ApplicationListener<ContextRefreshedEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ивент");
        ApplicationContext context = event.getApplicationContext();
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            Object bean = context.getBean(definitionName);
            Method[] methods = bean.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PostProxyConstruct.class)) {
                    System.out.println("запускаю");
                    method.invoke(bean, method.getParameterTypes());
                    System.out.println("запустила" + method.getName());
                }
            }
        }
    }
}
