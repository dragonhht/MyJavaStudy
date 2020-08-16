# JavaPoet学习

-   `JavaPoet`是一个用于生成`.java`源文件的Java API

-   [示例](./src/main/java/com/gitee/carloshuang/One.java)

```java
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
        JavaFile file = JavaFile.builder("com.gitee.carloghuang", testOneClass).build();

        // 此处直接打印出内容
        System.out.println(file.toString());
    }

}
```

## 常用类说明

-   `TypeSpec`: 用于生成类、接口、枚举对象的类

-   `MethodSpec`: 用于生成方法、构造方法对象的类

-   `ParameterSpec`: 用于生成参数对象的类

-   `AnnotationSpec`: 用于生成注解对象的类

-   `FieldSpec`: 用于配置生成成员变量的类

-   `ClassName`: 通过包名和类名生成的对象(可完成相关包的导入)

-   `JavaFile`: 控制生成的Java文件的输出的类

## 代码特殊输出

-   `$L`: 输出字面量(将值输出替换),如: `.beginControlFlow("for (int i = $L; i < $L; i++)", from, to)`

-   `$S`: 输出字符串(会为字符添加引号), 如`.addStatement("System.out.println($S)", "Good boy")`

-   `$T`: 输出类型(替换字符为类型名，并完成必要的`import`), 如: `.addStatement("$T.out.println($S)", System.class, "Good boy")`

-   `$N`: 以名称引用生成的另一个声明(可用于引用定义的方法)

## 静态导入

-   使用`addStaticImport`可实现静态导入

```
// 生成源文件
JavaFile file = JavaFile.builder("com.gitee.carloghuang", testOneClass)
        // 静态导入
        .addStaticImport(Collections.class, "*")
        .build();
```


