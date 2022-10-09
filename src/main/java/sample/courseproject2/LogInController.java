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
    private TextField LogField;

    @FXML
    private Button LogInButton;

    @FXML
    private PasswordField PassField;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize() {
        LogInButton.setOnAction(actionEvent -> {
//            LogInButton.getScene().getWindow().hide();
            App.changeScene("MenuWindow.fxml");
        });

        SignUpButton.setOnAction( actionEvent ->{
//            SignUpButton.getScene().getWindow().hide();
            App.changeScene("SignUpWindow.fxml");
        });


    }
}