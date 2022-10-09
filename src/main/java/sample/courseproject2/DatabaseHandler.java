package sample.courseproject2;

import java.sql.*;

public class DatabaseHandler {

//    Connection connection = null;
    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_1989_quotes", "std_1989_quotes", "12345678");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public void LogInUser(String login, String password){
        try {
            Connection connection = getConnection();

            String query = "SELECT * FROM users WHERE Login = ? AND Password = ?;";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, login);
            statement.setString(2, password);

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                UserData.user = new User(result.getInt("id"), login, password, result.getString("claster"));
                App.changeScene("MenuWindow.fxml");
            } else {
                System.out.println("Пользователя не существует");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void SignUpUser(String login,String password,String claster){
        String insert = "INSERT INTO `users`(`Login`, `Password`, `claster`) VALUES (?,?,?)";
        try {
            Connection connection = getConnection();
        PreparedStatement prSt = connection.prepareStatement(insert);

        prSt.setString(1, login);
        prSt.setString(2, password);
        prSt.setString(3, claster);

        prSt.executeUpdate();
        connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddQuote(String Quote,String Teacher,String lesson,String date ){
        String insert = "INSERT INTO `quotes`(`quote`, `teacher_name`, `lesson`, `date`) VALUES (?,?,?,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement prSt = connection.prepareStatement(insert);

            prSt.setString(1, Quote);
            prSt.setString(2, Teacher);
            prSt.setString(3, lesson);
            prSt.setString(4, date);
            prSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
