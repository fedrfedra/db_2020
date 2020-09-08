package my_spring;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class BenchmarkAnnotation {

    public void BenchmarkMethods(Object t) {
        Method[] declaredMethods = t.getClass().getDeclaredMethods();
        ArrayList<Long> longArrayList = new ArrayList<>();
        for(Method method: declaredMethods){
            long startTime = System.nanoTime();
            method.setAccessible(true);
            var parameterTypes = method.getParameterTypes();
            //todo pass random values to method.invoke using parameterTypes
            //method.invoke();
            long endTime   = System.nanoTime();
            long totalTime = endTime - startTime;
            longArrayList.add(totalTime);
        }
        long sum = longArrayList.stream().mapToLong(e -> e).sum();
        System.out.println(sum);

    }
}
