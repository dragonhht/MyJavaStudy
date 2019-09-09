package simple;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Description.
 *
 * @author: huang
 * Date: 18-1-17
 */
public class ProxyHandler implements InvocationHandler {

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
        InvocationHandler invocationHandler = new ProxyHandler(userService);
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(), invocationHandler);
        userServiceProxy.getAge(3);
        userServiceProxy.getName(2);
        userServiceProxy.getRoom(2);

        // 保存动态代理生成的class文件
        /*byte[] bytes = ProxyGenerator.generateProxyClass("$proxy0", userService.getClass().getInterfaces());
        File file = new File("$proxy.class");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        out.write(bytes);
        out.close();*/
    }
}
