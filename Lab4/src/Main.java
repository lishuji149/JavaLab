import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        Method[] methods = test.getClass().getDeclaredMethods();//获取类中的所有方法,不能保证返回顺序
        for (Method method : methods) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {//判断注解是否存在
                method.setAccessible(true);//true表示反射对象应在使用时抑制Java语言访问检查，可以访问私有成员
                for (int i = 0; i < method.getAnnotation(MyAnnotation.class).value(); i++) {
                    try {
                        method.invoke(test);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
