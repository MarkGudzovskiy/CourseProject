package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AddQuotesController {

    @FXML
    private Button BackButton;

    @FXML
    private Button AddQuotesButton;

    @FXML
    private TextField DataField;

    @FXML
    private TextField LessonField;

    @FXML
    private TextArea QuoteField;

    @FXML
    private TextField TeacherFIeld;

    @FXML
    void initialize(){
        DatabaseHandler db = new DatabaseHandler();
        AddQuotesButton.setOnAction(actionEvent -> {
            db.AddQuote(QuoteField.getText(),TeacherFIeld.getText(),LessonField.getText(),DataField.getText(),UserData.user.getId(),UserData.user.getClaster());
        });
        BackButton.setOnAction(actionEvent -> {
            App.changeScene("MenuWindow.fxml");
        });
    }
}
