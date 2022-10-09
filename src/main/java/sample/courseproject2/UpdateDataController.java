package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UpdateDataController {

    @FXML
    private TextField ClasterField;

    @FXML
    private TextField LogField;

    @FXML
    private TextField LogField1;

    @FXML
    private PasswordField PassField;

    @FXML
    private PasswordField PassField1;

    @FXML
    private Button RegButton;

    @FXML
    private Button RegButton1;

    @FXML
    void initialize(){
        DatabaseHandler db = new DatabaseHandler();
        RegButton.setOnAction(actionEvent -> {
            db.UpdateData(LogField1.getText(),PassField1.getText(),LogField.getText(),PassField.getText(),ClasterField.getText());
        });
        RegButton1.setOnAction(actionEvent -> {
            App.changeScene("MenuWindow.fxml");
        });
    }
}
