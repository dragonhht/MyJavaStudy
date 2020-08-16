# APT 学习

```
APT(Annotation Processing Tool): 通过该技术可在编译期解析注解，并生成Java代码
```

## 使用

-   创建自定义注解([示例](./src/main/java/com/gitee/carloshuang/anno/CustomAnnotation.java))

```java
@Documented
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface CustomAnnotation {
}
```

-   创建自定义注解处理器([示例](./src/main/java/com/gitee/carloshuang/processor/CustomProcessor.java))

```java
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
```

-   `使用SPI机制，使用处理器`: 在`resources`目录下创建文件夹`META-INF/services/`,并在该文件夹下创建文件名称为`javax.annotation.processing.Processor`的文件，文件内容为自定义注解的全限定类名, 如`com.gitee.carloshuang.processor.CustomProcessor`

-   打包成jar包后，在gradle中添加，如`annotationProcessor files('lib\\apt-study-1.0-SNAPSHOT.jar')`
