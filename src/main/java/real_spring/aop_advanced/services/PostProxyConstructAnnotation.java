package real_spring.aop_advanced.services;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PostProxyConstructAnnotation implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    public ConfigurableListableBeanFactory factory;
    @SneakyThrows
    @Override

    public void onApplicationEvent(ContextRefreshedEvent event) {

        ApplicationContext context = event.getApplicationContext();
        String[] definitionNames = context.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            BeanDefinition definition = factory.getBeanDefinition(definitionName);
            String realBeanClassName = definition.getBeanClassName();
//            System.out.println(realBeanClassName);
            Class<?> aClass = Class.forName(realBeanClassName);
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(PostProxyConstruct.class)) {
                    Object bean = context.getBean(definitionName);
                    Method realMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                    realMethod.invoke(bean, method.getParameterTypes());
                    System.out.println("сработал");
                }
            }
        }
    }
}
