package principle;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-9-9
 */
public final class MyProxyGenerator {

    private static final String PACKAGE_NAME = "com.github.dragonhht";
    private static final String WRAP = "\n";

    public static Class<?> generateProxyClass(String className, Class<?>[] insterfaces) throws IOException, ClassNotFoundException {
        String context = classContext(className, insterfaces);
        saveJavaFile(context, className);
        compile(className);
        return loadClass(className + ".class", className);
    }

    private static String classContext(String className, Class<?>[] insterfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package ")
                .append(PACKAGE_NAME)
                .append(";")
                .append(WRAP)
                .append("import principle.MyInvocationHandler;")
                .append(WRAP)
                .append("import java.lang.reflect.Method;")
                .append(WRAP)
                .append("import principle.MyProxy;")
                .append(WRAP)
                .append("import java.lang.reflect.UndeclaredThrowableException;")
                .append(WRAP);
        sb.append("public final class ")
                .append(className)
                .append(" ")
                .append("extends MyProxy implements ");
        for (Class<?> ints : insterfaces) {
            sb.append(ints.getName());
        }
        sb.append(" {").append(WRAP);

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
                .append("(MyInvocationHandler h) {")
                .append(WRAP)
                .append("super(h);")
                .append(WRAP)
                .append("}")
                .append(WRAP);

        methodIndex = 0;
        StringBuffer staticSb = new StringBuffer();
        staticSb.append("static {")
                .append(WRAP)
                .append("try {")
                .append(WRAP);
        for (Class<?> ints : insterfaces) {
            Method[] methods = ints.getDeclaredMethods();
            for (Method method : methods) {
                staticSb.append("m")
                        .append(methodIndex)
                        .append(" = Class.forName(\"")
                        .append(ints.getName())
                        .append("\").getMethod(\"")
                        .append(method.getName())
                        .append("\"");

                sb.append("public final ")
                        .append(method.getReturnType().getTypeName())
                        .append(" ")
                        .append(method.getName())
                        .append("(");
                Class<?>[] params = method.getParameterTypes();
                int index = 0;
                for (Class<?> param : params) {
                    if (index == 0) {
                        staticSb.append(", ");
                    }
                    staticSb.append(param.getTypeName())
                            .append(".class, ");

                    sb.append(param.getName())
                            .append(" ")
                            .append("var")
                            .append(index++)
                            .append(", ");
                }
                if (index > 0) {
                    sb.delete(sb.lastIndexOf(", "), sb.length() - 1);
                    staticSb.delete(staticSb.lastIndexOf(", "), staticSb.length() - 1);
                }
                sb.append(") {")
                        .append(WRAP)
                        .append("try {")
                        .append(WRAP);
                if (!method.getReturnType().getTypeName().equals("void")) {
                    sb.append("return ")
                            .append("(")
                            .append(method.getReturnType().getTypeName())
                            .append(")");
                }
                sb.append("super.h.invoke(this, ")
                        .append("m")
                        .append(methodIndex++);
                if (index > 0) {
                    sb.append(", new Object[]{");
                    index = 0;
                    for (Class<?> param : params) {
                        sb.append("var")
                                .append(index++)
                                .append(", ");
                    }
                    if (index > 0) {
                        sb.delete(sb.lastIndexOf(", "), sb.length() - 1);
                    }
                    sb.append("});");
                } else {
                    sb.append(", (Object[])null);");
                }


                sb.append("} catch (RuntimeException | Error var")
                        .append(index)
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
                staticSb.append(");")
                        .append(WRAP);
            }
        }
        staticSb.append("} catch (NoSuchMethodException var2) {")
                .append(WRAP)
                .append("throw new NoSuchMethodError(var2.getMessage());")
                .append(WRAP)
                .append("} catch (ClassNotFoundException var3) {")
                .append(WRAP)
                .append("throw new NoClassDefFoundError(var3.getMessage());")
                .append(WRAP)
                .append("}")
                .append(WRAP)
                .append("}");
        sb.append(staticSb.toString());
        sb.append(WRAP)
                .append("}");
        return sb.toString();
    }

    /**
     * 将类信息保存为java文件
     * @param context
     * @param className
     */
    private static void saveJavaFile(String context, String className) throws IOException {
        String prefixPath = PACKAGE_NAME.replace('.', File.separatorChar);
        File file = new File(prefixPath + File.separatorChar + className + ".java");
        if (!file.exists()) {
            createFile(file);
        }
        Path path = file.toPath();
        Files.write(path, context.getBytes());
    }

    private static void createFile(File file) throws IOException {
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
            file.createNewFile();
        } else {
            file.createNewFile();
        }
    }

    /**
     * 编译
     */
    private static void compile(String className) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        String prefixPath = PACKAGE_NAME.replace('.', File.separatorChar);
        File file = new File(prefixPath + File.separatorChar + className + ".java");
        int result = compiler.run(null, null, null, file.getAbsolutePath());
        System.out.println(result);
    }

    private static Class<?> loadClass(String path, String name) throws MalformedURLException, ClassNotFoundException {
        File file = new File("");
        MyClassLoader classLoader = new MyClassLoader(file.getAbsolutePath());
        return Class.forName(PACKAGE_NAME + "." + name, true, classLoader);
    }

}
