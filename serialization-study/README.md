-   jprotobuf使用说明

    -   需在实体类的属性中使用注解:
    
        ```java
        public class Person {
        
            @Protobuf(fieldType = FieldType.STRING)
            private String id;
    
            @Protobuf(fieldType = FieldType.STRING)
            private String name;
    
            @Protobuf(fieldType = FieldType.STRING)
            private String address;
        }
        ```
        
    -   可不实现`Serializable`接口
    
    -   [示例](./src/test/java/com/github/dragonhht/ByteTest.java)
    

-   可不实现`Serializable`接口： `JProtoBuf`、`Protostuff`