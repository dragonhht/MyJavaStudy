package principle;

import java.io.Serializable;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-9-9
 */
public class MyProxy implements Serializable {
    private static final long serialVersionUID = 7121831343481232586L;

    protected MyInvocationHandler h;

    public MyProxy(MyInvocationHandler h) {
        Objects.requireNonNull(h);
        this.h = h;
    }

    public static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, MyInvocationHandler h)
            throws IllegalArgumentException {
        // MyInvocationHandler对象不能为空
        Objects.requireNonNull(h);
        Class<?>[] insts = interfaces.clone();

        try {
            return getProxyClass(loader, insts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static final Class getProxyClass(ClassLoader classLoader, Class<?>[] insterfaces) throws Exception {
        return new MyProxyClassFactory().apply(classLoader, insterfaces);
    }

    private static class MyProxyClassFactory {
        private static int index = 1;
        private static final String CLASS_NAME = "$Proxy";

        public Class<?> apply(ClassLoader loader, Class<?>[] interfaces) throws Exception {
            Map<Class<?>, Boolean> insterfaceMap = new IdentityHashMap<>(interfaces.length);
            for (Class<?> cls : interfaces) {
                Class<?> interfaceClass = Class.forName(cls.getName(), false, loader);
                if (!interfaceClass.isInterface()) {
                    throw new Exception(interfaceClass.getName() + " 不是一个接口");
                }
                if (insterfaceMap.put(interfaceClass, Boolean.TRUE) != null) {
                    throw new Exception("重复的接口： " + interfaceClass.getName());
                }
            }

            MyProxyGenerator.generateProxyClass(CLASS_NAME + index++, interfaces);

            return null;
        }
    }
}
