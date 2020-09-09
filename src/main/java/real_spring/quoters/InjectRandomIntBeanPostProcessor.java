package real_spring.quoters;

import heroes.RandomUtil;
import lombok.SneakyThrows;
import my_spring.InjectByType;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
@Component
public class InjectRandomIntBeanPostProcessor implements BeanPostProcessor {

    @SneakyThrows
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                if (annotation != null) {
                    int randomInt = RandomUtil.getIntBetween(annotation.min(), annotation.max());
                    field.setAccessible(true);
                    field.setInt(bean, randomInt);
                }

            }
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }


}
