import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: alangong
 * @create: 2020-09-01 11:24
 * @description:
 **/
public class JDKProxy implements InvocationHandler {
    private Object subject;

    JDKProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start transaction");
        Object result = method.invoke(subject, args);
        System.out.println("commit");
        return result;
    }
}
