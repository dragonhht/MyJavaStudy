package javafx.study.sample;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.study.sample.controller.Controller;
import javafx.study.sample.controller.EditController;
import javafx.study.sample.model.Person;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    /** 保存数据的集合. */
    private ObservableList<Person> persons = FXCollections.observableArrayList();

    /**
     * 初始化数据.
     */
    public Main() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person("张" + i, "三" + i);
            persons.add(person);
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Hello World");

        initRootLayout();
        showBody();
    }


    /**
     * 初始化RootLayout.xml.
     */
    public void initRootLayout() throws IOException {

        // 创建 FXMLLoader 对象
        FXMLLoader loader = new FXMLLoader();
        // 加载文件
        loader.setLocation(this.getClass().getResource("/RootLayout.fxml"));
        rootLayout = loader.load();

        // 显示场景
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * 在 rootLayout 中设置其他fxml文件.
     */
    public void showBody() throws IOException {
        // 创建 FXMLLoader 对象
        FXMLLoader loader = new FXMLLoader();
        // 加载文件
        loader.setLocation(this.getClass().getResource("/sample.fxml"));
        GridPane gridPane = loader.load();

        // 将 GridPane 加入到 rootLayout
        rootLayout.setCenter(gridPane);

        Controller controller = loader.getController();
        controller.setMain(this);
    }

    /**
     * 获取person数据.
     * @return person数据
     */
    public ObservableList<Person> getPersons() {
        return persons;
    }

    /**
     * 添加编辑对话框.
     * @param person
     * @return
     */
    public boolean showEditDialog(Person person) throws IOException {
        // 创建 FXMLLoader 对象
        FXMLLoader loader = new FXMLLoader();
        // 加载文件
        loader.setLocation(this.getClass().getResource("/editLayout.fxml"));
        AnchorPane pane = loader.load();

        // 创建对话框
        Stage dialogStage = new Stage();
        dialogStage.setTitle("编辑");
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(pane);
        dialogStage.setScene(scene);

        // 设置人员信息
        EditController edit = loader.getController();
        edit.setDialogStage(dialogStage);
        edit.setPerson(person);

        // 显示对话框, 并等待, 直到用户关闭
        dialogStage.showAndWait();

        return edit.isOkChecked();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
