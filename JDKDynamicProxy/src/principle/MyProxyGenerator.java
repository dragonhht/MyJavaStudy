package principle;

import java.lang.reflect.Method;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-9-9
 */
public final class MyProxyGenerator {

    private static final String PACKAGE_NAME = "com.github.dragonhht";
    private static final String WRAP = "\n";

    public static byte[] generateProxyClass(String className, Class<?>[] insterfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(PACKAGE_NAME)
                .append(";")
                .append(WRAP)
                .append("import java.lang.reflect.InvocationHandler;")
                .append(WRAP)
                .append("import java.lang.reflect.Method;")
                .append(WRAP)
                .append("import principle.MyProxy;")
                .append(WRAP)
                .append("import java.lang.reflect.UndeclaredThrowableException;")
                .append(WRAP);
        sb.append("public final class ")
                .append(className)
                .append("extends MyProxy implements ");
        for (Class<?> ints : insterfaces) {
            sb.append(ints.getName());
        }
        sb.append("{").append(WRAP);

        int methodIndex = 0;
        for (Class<?> ints : insterfaces) {
            Method[] methods = ints.getDeclaredMethods();
            for (Method method : methods) {
                sb.append("private static Method m")
                        .append(methodIndex++)
                        .append(";")
                        .append(WRAP);
            }
        }

        sb.append("public ")
                .append(className)
                .append("(MyInvocationHandler h)")
                .append(WRAP)
                .append("super(h);")
                .append(WRAP)
                .append("}")
                .append(WRAP);

        methodIndex = 0;
        for (Class<?> ints : insterfaces) {
            Method[] methods = ints.getDeclaredMethods();
            for (Method method : methods) {
                sb.append("public final ")
                        .append(method.getReturnType().getTypeName())
                        .append(" ")
                        .append(method.getName())
                        .append("(");
                Class<?>[] params = method.getParameterTypes();
                int index = 0;
                int paramCount = 0;
                for (Class<?> param : params) {
                    sb.append(param.getName())
                            .append(" ")
                            .append("var")
                            .append(index++)
                            .append(", ");
                }
                if (index > 0) {
                    sb.delete(sb.lastIndexOf(", "), sb.length() - 1);
                }
                sb.append(") {")
                        .append(WRAP)
                        .append("try {")
                        .append(WRAP)
                        .append("return ")
                        .append("(")
                        .append(method.getReturnType().getTypeName())
                        .append(")")
                        .append("super.h.invoke(this, ")
                        .append("m")
                        .append(methodIndex++)
                        .append(", new Object[]{");
                index = 0;
                for (Class<?> param : params) {
                    sb.append("var")
                            .append(index++)
                            .append(", ");
                }
                if (index > 0) {
                    sb.delete(sb.lastIndexOf(", "), sb.length() - 1);
                }
                sb.append("});")
                        .append("} catch (RuntimeException | Error var")
                        .append(index++)
                        .append(") {")
                        .append(WRAP)
                        .append("throw var")
                        .append(index)
                        .append(";")
                        .append(WRAP)
                        .append("} catch (Throwable var")
                        .append(++index)
                        .append(") {")
                        .append(WRAP)
                        .append("throw new UndeclaredThrowableException(var")
                        .append(index)
                        .append(");")
                        .append(WRAP)
                        .append("}")
                        .append(WRAP)
                        .append("}")
                        .append(WRAP);
            }
        }
        System.out.println(sb.toString());
        return sb.toString().getBytes();
    }

}
