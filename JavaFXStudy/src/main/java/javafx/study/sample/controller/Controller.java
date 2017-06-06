package javafx.study.sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.study.sample.Main;
import javafx.study.sample.model.Person;

import java.io.IOException;

/**
 * 所有fxml文件需要访问的属性和方法必须加上 @FXML 注解, (共有的不需要)
 * 要将组件的id设置成相对应的变量名才可正确装载数据.
 */

public class Controller {


    @FXML
    private TableView<Person> personTable;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstName;
    @FXML
    private Label lastName;
    @FXML
    private Label sex;

    private Main main;

    /**
     * 将数据装载到界面
     * 在fxml文件完成载入时被自动调用. 那时, 所有的FXML属性都应已被初始化.
     */
    @FXML
    private void initialize() {
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // 清空人员具体信息
        showPersonDetails(null);

        // 监听选择,并改变展示的信息
        personTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue)
        );
    }


    public void setMain(Main mainApp) {
        this.main = mainApp;
        this.personTable.setItems(this.main.getPersons());
    }


    /**
     * 显示人员的具体信息.
     * @param person 人员信息
     */
    private void showPersonDetails(Person person) {

        if (person != null) {
            firstName.setText(person.getFirstName());
            lastName.setText(person.getLastName());
            sex.setText(person.getSex());
        } else {
            firstName.setText("");
            lastName.setText("");
            sex.setText("");
        }
    }

    /**
     * 删除.
     */
    @FXML
    private void del() {
        // 获取选择的组件的索引
        int selectIndex = personTable.getSelectionModel().getSelectedIndex();

        if (selectIndex >= 0) {
            // 移除组件
            personTable.getItems().remove(selectIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("提示");
            alert.setHeaderText("请选择一个人员");
            alert.show();
        }
    }


    /**
     * 点击新建按钮.
     */
    @FXML
    private void handleNew() throws IOException {

        Person tempPerson = new Person();
        boolean ok = this.main.showEditDialog(tempPerson);
        if (ok) {
            this.main.getPersons().add(tempPerson);
        }
    }

    /**
     * 点击编辑按钮.
     */
    @FXML
    private void handlerEdit() throws IOException {
        Person person = personTable.getSelectionModel().getSelectedItem();
        if (person != null) {
            boolean ok = this.main.showEditDialog(person);
            if (ok) {
                showPersonDetails(person);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("提示");
            alert.setHeaderText("请选择一个人员");
            alert.show();
        }
    }



}
