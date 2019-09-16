package principle.test;

import principle.MyInvocationHandler;
import principle.MyProxy;
import simple.UserService;
import simple.UserServiceImpl;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-1-17
 */
public class ProxyHandler implements MyInvocationHandler {

    private Object target;

    public ProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("前置增强");
        result = method.invoke(target, args);
        System.out.println("后置增强");
        return result;
    }

    public static void main(String[] args) throws IOException {
        UserService userService = new UserServiceImpl();
        MyInvocationHandler invocationHandler = new ProxyHandler(userService);
        UserService userServiceProxy = (UserService) MyProxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.getName(123);
    }
}
