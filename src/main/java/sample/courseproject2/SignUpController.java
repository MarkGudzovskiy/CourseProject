package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignUpController {

    @FXML
    private TextField ClasterField;

    @FXML
    private TextField LogField;

    @FXML
    private PasswordField PassField;

    @FXML
    private Button RegButton;

    @FXML
    void initialize(){
        DatabaseHandler dbHandler = new DatabaseHandler();

        RegButton.setOnAction(actionEvent -> {
            dbHandler.SignUpUser(LogField.getText(),PassField.getText(),ClasterField.getText());
        });
    }
}


