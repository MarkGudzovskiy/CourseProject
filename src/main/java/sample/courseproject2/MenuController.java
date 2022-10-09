package sample.courseproject2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController {

    @FXML
    private Button AddQuotesButton;

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

//    @FXML
//    void initialize(){
//        QuotesButton.setOnAction(actionEvent -> {
//            System.out.println(1);
////            QuotesButton.getScene().getWindow().hide();
//            App.changeScene("QuotesWindow.fxml");
//        });
//
//        AddQuotesButton.setOnAction(actionEvent -> {
////            AddQuotesButton.getScene().getWindow().hide();
//            App.changeScene("AddQuotesWindow.fxml");
//        });
//    }

}
