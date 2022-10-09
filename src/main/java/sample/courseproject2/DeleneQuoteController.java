package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class DeleneQuoteController {

    @FXML
    private TextField LogField;

    @FXML
    private Button LogInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    void initialize(){
        DatabaseHandler db = new DatabaseHandler();
        LogInButton.setOnAction(actionEvent -> {
            db.DeleteQuote(Integer.parseInt(LogField.getText()));
        });
        SignUpButton.setOnAction(actionEvent -> {
            App.changeScene("MenuWindow.fxml");
        });
    }
}
