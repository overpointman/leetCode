import java.lang.reflect.Proxy;

/**
 * @author: alangong
 * @create: 2020-09-01 18:36
 * @description:
 **/
public class UserServiceImplProxy implements UserService{
    private UserService userService;

    UserServiceImplProxy(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void printName() {
        System.out.println("start transaction");
        userService.printName();
        System.out.println("commit");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = UserServiceImpl.class;
        UserService userService = (UserService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(),
                new JDKProxy(clazz.newInstance()));
        userService.printName();
        System.out.println(UserService.class.newInstance());
    }
}
