package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class QuotesController {

    @FXML
    private Button BackButton;

    @FXML
    private TableColumn<?, ?> DateColumn;

    @FXML
    private TableColumn<?, ?> LessonColumn;

    @FXML
    private TableColumn<?, ?> QuoteColumn;

    @FXML
    private TableView<?> QuotesTable;

    @FXML
    private TableColumn<?, ?> TeacherColumn;

    @FXML
    void initialize(){
        BackButton.setOnAction(actionEvent -> {
            BackButton.getScene().getWindow().hide();
            App.changeScene("MenuWindow.fxml");
        });

    }

}
