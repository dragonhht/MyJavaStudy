package com.gitee.carloshuang.processor;

import com.gitee.carloshuang.anno.CustomAnnotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.Writer;
import java.util.Set;

/**
 * 自定义注解处理器.
 *
 * @author: Carlos Huang
 * @Date: 2020-8-16
 */
// 指定该注解处理器可以处理的类型
@SupportedAnnotationTypes("com.gitee.carloshuang.anno.CustomAnnotation")
// 指定JDK版本
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CustomProcessor extends AbstractProcessor {

    private Types mTypeUtils;
    private Elements mElementUtils;
    private Filer mFiler;
    private Messager mMessager;

    // 处理注解的核心方法，创建Java代码，写入文件，然后会被解释称class文件
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        mTypeUtils = processingEnv.getTypeUtils();
        mElementUtils = processingEnv.getElementUtils();
        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();

        // 获取多有被指定注解修改的代码元素
        for (Element element : roundEnv.getElementsAnnotatedWith(CustomAnnotation.class)) {
            String packageName = mElementUtils.getPackageOf(element).getQualifiedName().toString();
            String typeName = element.getSimpleName().toString() + "Iml";
            String javaCode = createJavaCode(packageName, typeName);
            // 写入文件
            try {
                JavaFileObject source = processingEnv.getFiler()
                        .createSourceFile(packageName + "." + typeName);
                Writer writer = source.openWriter();
                writer.write(javaCode);
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private String createJavaCode(String packageName, String name) {

        // 创建Java代码
        StringBuilder sb = new StringBuilder()
                .append("package ")
                .append(packageName)
                .append(";\n")
                .append("public class ")
                .append(name)
                .append(" {\n")
                .append("public void print() {\n")
                .append("System.out.println(\"hello\");\n")
                .append("}\n}");
        return sb.toString();
    }
}
