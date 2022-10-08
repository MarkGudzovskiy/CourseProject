package sample.courseproject2;

import java.sql.*;

public class DatabaseHandler {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1989_quotes", "std_1989_quotes", "12345678");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void LogInUser(){

    }

    public void SignUpUser(String login,String password,String claster){
        String insert = "INSERT INTO `users`(`Login`, `Password`, `claster`) VALUES (?,?,?)";
        try {
        PreparedStatement prSt = getConnection().prepareStatement(insert);

        prSt.setString(1, login);
        prSt.setString(2, password);
        prSt.setString(3, claster);

        prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
