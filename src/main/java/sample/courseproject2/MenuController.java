package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MenuController {

    @FXML
    private Button AddQuotesButton;

    @FXML
    private Button QuotesButton;

    @FXML
    private AnchorPane SignUpButton;

    @FXML
    private Button UpdateData;

    @FXML
    private Button UpdateQuotesButton;

    @FXML
    void initialize(){
        QuotesButton.setOnAction(actionEvent -> {
            System.out.println(1);
            QuotesButton.getScene().getWindow().hide();
            App.changeScene("QuotesWindow.fxml");
        });
    }
    public void getMenu(){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("MenuWindow.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 700,400);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
