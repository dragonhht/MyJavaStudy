package com.gitee.carloshuang;

import com.squareup.javapoet.*;

import javax.lang.model.element.Modifier;
import java.util.Collections;

/**
 * 使用JavaPoet创建一个简单类.
 *
 * @author: Carlos Huang
 * @Date: 2020-8-16
 */
public class One {

    public static void main(String[] args) {
        // 要生成的类实现的接口
        ClassName supperClass = ClassName.get("com.gitee.carloshuang", "TestInterface");
        // 创建生成类的对象
        TypeSpec.Builder classBuilder = TypeSpec.classBuilder("TestOneClass") // 定义类名
                // 添加修饰符
                .addModifiers(Modifier.PUBLIC)
                // 实现接口
                .addSuperinterface(supperClass);

        // 创建方法
        // 方法使用的注解
        ClassName override = ClassName.get("java.lang", "Override");
        // 方法需要的参数类型
        ClassName strType = ClassName.get("java.lang", "String");
        // 创建方法需要的参数(name 参数)
        ParameterSpec name = ParameterSpec.builder(strType, "name").build();
        // 创建方法
        MethodSpec printMethod = MethodSpec.methodBuilder("print") //定义方法名
                // 添加方法注解
                .addAnnotation(override)
                // 添加修饰符
                .addModifiers(Modifier.PUBLIC)
                // 设置返回类型
                .returns(String.class)
                // 添加参数
                .addParameter(name)
                .addParameter(Integer.class, "num")
                // 添加方法内代码
                .addStatement("$T.out.println($S)", System.class, "Good boy")
                .addStatement("System.out.println(\"hello\" + name)")
                .addCode("int index = 0;\n"
                        + "while(index < 2) {\n"
                        + "     index++;\n"
                        + "}\n"
                )
                // 添加控制流代码(此处示例为for循环)
                .beginControlFlow("for (int i = 0; i < 3; i++)")
                .addStatement("index += i")
                .endControlFlow()
                .addStatement("return name")
                .build();

        // 为类添加方法和成员变量
        TypeSpec testOneClass = classBuilder.addMethod(printMethod)
                // 添加成员变量
                .addField(int.class, "age", Modifier.PRIVATE)
                .build();

        // 生成源文件
        JavaFile file = JavaFile.builder("com.gitee.carloghuang", testOneClass)
                // 静态导入
                .addStaticImport(Collections.class, "*")
                .build();

        // 此处直接打印出内容
        System.out.println(file.toString());
    }

}
