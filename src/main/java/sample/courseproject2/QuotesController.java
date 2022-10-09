package sample.courseproject2;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class QuotesController {

    @FXML
    private Button BackButton;

    @FXML
    private TableColumn<Quote, Integer> IDcolumn;

    @FXML
    private TableColumn<Quote, String> DateColumn;

    @FXML
    private TableColumn<Quote, String> LessonColumn;

    @FXML
    private TableColumn<Quote, String> QuoteColumn;

    @FXML
    private TableView<Quote> QuotesTable;

    @FXML
    private TableColumn<Quote, String> TeacherColumn;

    @FXML
    private AnchorPane Text;



    @FXML
    void initialize(){
        BackButton.setOnAction(actionEvent -> {
            if(!UserData.user.getClaster().equals("Guest")){
                App.changeScene("MenuWindow.fxml");
            } else {
                App.changeScene("LogInWindow.fxml");
            }

        });
        ReturnQuotes();
    }

    public void ReturnQuotes(){
        DatabaseHandler db = new DatabaseHandler();
        try {
            Connection connection = db.getConnection();

            String query = "SELECT * FROM quotes";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt("id");
//                String id = Integer.toString(idt);
                String quote = resultSet.getString("quote");
                String teacher = resultSet.getString("teacher_name");
                String lesson = resultSet.getString("lesson");
                String date = resultSet.getString("date");

                QuotesTable.getItems().addAll(new Quote(id,quote, teacher, lesson, date));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        IDcolumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        QuoteColumn.setCellValueFactory(new PropertyValueFactory<>("Quote"));
        TeacherColumn.setCellValueFactory(new PropertyValueFactory<>("Teacher"));
        LessonColumn.setCellValueFactory(new PropertyValueFactory<>("Lesson"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
    }
}
