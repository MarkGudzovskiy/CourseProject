module sample.courseproject2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens sample.courseproject2 to javafx.fxml;
    exports sample.courseproject2;
}