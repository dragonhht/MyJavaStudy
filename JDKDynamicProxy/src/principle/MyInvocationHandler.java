package principle;

import java.lang.reflect.Method;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-9-9
 */
public interface MyInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable;
}
