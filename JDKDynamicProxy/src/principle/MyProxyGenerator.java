package principle;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

/**
 * .
 *
 * @author: huang
 * @Date: 2019-9-9
 */
public final class MyProxyGenerator {

    private static final String PACKAGE_NAME = "com.github.dragonhht";
    private static final String WRAP = "\n";

    public static byte[] generateProxyClass(String className, Class<?>[] insterfaces) throws IOException {
        String context = classContext(className, insterfaces);
        saveJavaFile(context, className);
        compile(className);
        return context.getBytes();
    }

    private static String classContext(String className, Class<?>[] insterfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package ")
                .append(PACKAGE_NAME)
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
                    sb.append(", (Object[])null");
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
        System.out.println(sb.toString());
        return sb.toString();
    }

    /**
     * 将类信息保存为java文件
     * @param context
     * @param className
     */
    private static void saveJavaFile(String context, String className) throws IOException {
        File file = new File(className + ".java");
        if (!file.exists()) {
            file.createNewFile();
        }
        Path path = file.toPath();
        Files.write(path, context.getBytes());
    }

    /**
     * 编译
     */
    private static void compile(String path) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iterable = standardFileManager.getJavaFileObjects(new File(path));
        // 编译参数
        List<String> options = Arrays.asList("-d", System.getProperty("user.dir"));

        // 创建一个编译任务
        List<String> classes = null;
        JavaCompiler.CompilationTask task = compiler.getTask(null, standardFileManager, null, options, classes, iterable);
        boolean result = task.call();
        if (result) {
            System.out.println("类编译成功");
        } else {
            System.out.println("类编译失败");
        }
    }

}
