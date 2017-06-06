package javafx.study.sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.study.sample.model.Person;

/**
 * Created by huang on 17-6-6.
 * 编辑界面控制器.
 */
public class EditController {

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField sex;

    private Stage dialogStage;
    private Person person;
    private boolean okChecked = false;

    /**
     * 初始化
     */
    @FXML
    private void initialize() {

    }

    /**
     * 设置dialogStage
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * 设置人员信息.
     * @param person
     */
    public void setPerson(Person person) {
        this.person = person;

            firstName.setText(person.getFirstName());
            lastName.setText(person.getLastName());
            sex.setText(person.getSex());


    }

    /**
     * 点击ok.
     */
    @FXML
    private void handleOk() {

        person.setFirstName(firstName.getText());
        person.setLastName(lastName.getText());
        person.setSex(sex.getText());

        okChecked = true;
        dialogStage.close();
    }

    /**
     * 点击Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    public boolean isOkChecked() {
        return okChecked;
    }

}
