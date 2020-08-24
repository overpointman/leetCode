import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.Provider;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author: alangong
 * @create: 2020-08-18 13:01
 * @description:
 **/
public class Reflect {
    private final static int i = 5;
    private void A() {
        System.out.println("我是私有方法A");
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Reflect r = new Reflect();
        Method methods = r.getClass().getDeclaredMethod("A");
        methods.invoke(r);
        System.out.println(String.class.getClassLoader());
        System.out.println(Provider.class.getClassLoader());
        System.out.println(Reflect.class.getClassLoader());
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("jre_home"));
        System.out.println(System.getenv("JAVA_HOME"));
    }
}
