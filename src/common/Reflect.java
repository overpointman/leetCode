import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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
    }
}
