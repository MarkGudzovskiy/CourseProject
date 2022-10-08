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
        SignUpButton.setOnAction( actionEvent ->{
            SignUpButton.getScene().getWindow().hide();
            System.out.println(1);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("SignUpWindow.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.showAndWait();
        });

//        LogInButton.setOnAction(actionEvent -> );

    }
}