# SPI的使用

-   [调用方定义接口](./spi-common-api/src/main/java/com/gitee/carloshuang/api/HelloSpiService.java)

-   [调用方在通过ServiceLoader调用](./spi-caller/src/main/java/com/gitee/carloshuang/call/SPICaller.java)

-   [提供方实现接口](./spi-impl/src/main/java/com/gitee/carloshuang/impl/HelloSpiServiceImpl.java)

-   [调用方在META-INF中定义配置](./spi-impl/src/main/resources/META-INF/services)

    -   在目录`META-INF/services`下创建文件，文件名为实现的接口的全限定名称, 文件中的内容每行为该接口的实现类
    
    -   将实现项目打包成jar，供调用方引用
