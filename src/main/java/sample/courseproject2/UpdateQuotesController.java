package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class UpdateQuotesController {

    @FXML
    private Button AddQuotesButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField DataField;

    @FXML
    private TextField IdFIeld;

    @FXML
    private TextField LessonField;

    @FXML
    private TextArea QuoteField;

    @FXML
    private TextField TeacherFIeld;

    @FXML
    void initialize(){
        DatabaseHandler db = new DatabaseHandler();
        AddQuotesButton.setOnAction( actionEvent -> {
            db.UpdateQuote(Integer.parseInt(IdFIeld.getText()),QuoteField.getText(),TeacherFIeld.getText(),LessonField.getText(),DataField.getText());
        });

        BackButton.setOnAction(actionEvent -> {
            App.changeScene("MenuWindow.fxml");
        });
    }

}
