package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController {

    @FXML
    private Button LogInButton1;

    @FXML
    private TextField LogField;

    @FXML
    private Button LogInButton;

    @FXML
    private PasswordField PassField;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {
        DatabaseHandler db = new DatabaseHandler();
        LogInButton.setOnAction(actionEvent -> {
            String login = LogField.getText();
            String pass = PassField.getText();
            if(!LogField.getText().isEmpty() && !PassField.getText().isEmpty()){
                db.LogInUser(login,pass);
            }


        });

        LogInButton1.setOnAction(actionEvent -> {
            App.changeScene("QuotesWindow.fxml");
            UserData.user = new User(0,"","","Guest","");
        });

        SignUpButton.setOnAction( actionEvent ->{
            App.changeScene("SignUpWindow.fxml");
        });


    }
}