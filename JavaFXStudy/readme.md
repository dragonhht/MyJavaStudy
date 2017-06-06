# javaFX 学习
> 示例参照与网络中的示例


-   1, 创建fxml文件
> 使用 Scene Builder 创建相应的界面

-   2, 创建Main.java
> 加载fxml, 设置界面

-   3, 创建controller.java
> 将数据装载到界面  
> 所有fxml文件需要访问的属性和方法必须加上 @FXML 注解  
> setMain方法 用于设置数据  
> 在initialize方法中装载数据, 让其在初始化时装载数据

-   4, 将fxml与controller关联
> 在fxml文件中关联controller `fx:controller="javafx.study.sample.controller.Controller"`
> 在fxml中设置相应的组件的id(与controller中的变量名一致)  `fx:id="personTable"`

-   5, 选择改变
> 对 TableView 做监听, 通过 ChangeListener 的 changed 方法, 当选择改变时做出相应的处理

-   6, 设置按钮点击事件
> 在 controller 中编写相应的处理代码, private的则需 @FXML 注解, public则不需  
> 在fxml文件文件中设置相关按钮组件的 onAction 值为controller中写的方法名  

