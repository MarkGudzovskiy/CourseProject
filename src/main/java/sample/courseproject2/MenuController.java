package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class MenuController {

    @FXML
    private Button AddQuotesButtom;

    @FXML
    private Button QuotesButtom;

    @FXML
    private AnchorPane SignUpButton;

    @FXML
    private Button UpdateData;

    @FXML
    private Button UpdateQuotesButton;



    @FXML
    void identify(){
        QuotesButtom.setOnAction(actionEvent -> {
            SignUpButton.getScene().getWindow().hide();
            App.changeScene("QuotesWindow.fxml");
        });


    }
}
