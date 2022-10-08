package sample.courseproject2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("LogInWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        stage.setTitle("Quotes");
        stage.setScene(scene);
        stage.show();
    }

    public static Object changeScene(String fxml) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(App.class.getResource(fxml));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
        return null;
    }


    public static void main(String[] args) {
        launch();
    }
}