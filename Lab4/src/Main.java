import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        PrivateFunctions functions = new PrivateFunctions();
        Method[] methods = functions.getClass().getDeclaredMethods();
        for(Method method : methods) {
            if(method.isAnnotationPresent(Show.class)) {
                method.setAccessible(true);
                for(int i = 0; i < method.getAnnotation(Show.class).value(); i++) {
                    try {
                        if(method.getParameterCount() == 1) {
                            method.invoke(functions, 4);
                        } else {
                            method.invoke(functions);
                        }
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
