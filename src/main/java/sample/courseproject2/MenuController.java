package sample.courseproject2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button AddQuotesButton;

    @FXML
    private Button UpdateQuotesButton1;

    @FXML
    private Button QuotesButton;

    @FXML
    private Button UpdateData;

    @FXML
    private Button UpdateQuotesButton;

    @FXML
    void AddQuotes(ActionEvent event) {
        App.changeScene("AddQuotesWindow.fxml");
    }

    @FXML
    void Quotes(ActionEvent event) {
        App.changeScene("QuotesWindow.fxml");
    }

    @FXML
    void initialize(){
        UpdateQuotesButton.setOnAction(actionEvent -> {
            App.changeScene("UpdateQuoteWindow.fxml");
        });
        UpdateData.setOnAction(actionEvent -> {
            App.changeScene("UpdateData.fxml");
        });
        UpdateQuotesButton1.setOnAction(actionEvent -> {
            App.changeScene("DeleteQuote.fxml");
        });
    }

}
