package temp;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RefTemp {
    public void printHello(){
        System.out.println("hello in public method.");
    }

    private void printHelloByPrivate(){
        System.out.println("hello in private method.");
    }

    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("temp.RefTemp");
        Method method = clz.getDeclaredMethod("printHelloByPrivate");
        method.setAccessible(true);
        Constructor<?> constructor = clz.getConstructor();
        Object object = constructor.newInstance();
        method.invoke(object);

    }
}
