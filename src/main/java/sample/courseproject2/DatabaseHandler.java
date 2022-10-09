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
                UserData.user = new User(result.getInt("id"), login, password, result.getString("claster"),result.getString("study_group"));
                App.changeScene("MenuWindow.fxml");
            } else {
                System.out.println("Пользователя не существует");
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void SignUpUser(String login,String password,String claster, String group){
        String insert = "INSERT INTO `users`(`Login`, `Password`, `claster`, study_group) VALUES (?,?,?,?)";
        try {
            Connection connection = getConnection();
        PreparedStatement prSt = connection.prepareStatement(insert);

        prSt.setString(1, login);
        prSt.setString(2, password);
        prSt.setString(3, claster);
        prSt.setString(4,group);

        prSt.executeUpdate();
        connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AddQuote(String Quote,String Teacher,String lesson,String date,int id, String claster){
        String insert = "INSERT INTO `quotes`(`quote`, `teacher_name`, `lesson`, `date`, id_user, user_claster, study_group) VALUES (?,?,?,?,?,?,?)";
        try {
            Connection connection = getConnection();
            PreparedStatement prSt = connection.prepareStatement(insert);

            prSt.setString(1, Quote);
            prSt.setString(2, Teacher);
            prSt.setString(3, lesson);
            prSt.setString(4, date);
            prSt.setInt(5,id);
            prSt.setString(6,claster);
            prSt.setString(7,UserData.user.getGroup());
            prSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdateQuote(int id, String Quote,String Teacher,String lesson,String date ){
        try {
            Connection connection = getConnection();

            PreparedStatement prSt = null;
            String insert;
            if(UserData.user.getClaster().equals("admin")){
                insert = "UPDATE `quotes` SET `quote`= ? ,`teacher_name`= ? ,`lesson`= ? ,`date`= ? WHERE id = ?";
                prSt = connection.prepareStatement(insert);
            } else if(UserData.user.getClaster().equals("student")) {
                insert = "UPDATE `quotes` SET `quote`= ? ,`teacher_name`= ? ,`lesson`= ? ,`date`= ? WHERE id = ? and id_user = ?";
                prSt = connection.prepareStatement(insert);
                prSt.setInt(6, UserData.user.getId());
            } else if(UserData.user.getClaster().equals("starosta")) {
                insert = "UPDATE `quotes` SET `quote`= ? ,`teacher_name`= ? ,`lesson`= ? ,`date`= ? WHERE id = ? and study_group = ?";
                prSt = connection.prepareStatement(insert);
                prSt.setString(6, UserData.user.getGroup());
            }

            prSt.setString(1, Quote);
            prSt.setString(2, Teacher);
            prSt.setString(3, lesson);
            prSt.setString(4, date);
            prSt.setInt(5,id);
            prSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void UpdateData(String login,String pass,String newlogin,String newpass,String newclaster){

        String insert = "UPDATE `users` SET `Login`= ? ,`Password`= ? ,`Claster`= ?  WHERE Login = ? and Password = ?";
        try {

            Connection connection = getConnection();

            PreparedStatement prSt = connection.prepareStatement(insert);

            prSt.setString(1, newlogin);
            prSt.setString(2, newpass);
            prSt.setString(3, newclaster);
            prSt.setString(4, login);
            prSt.setString(5,pass);
            prSt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void DeleteQuote(int id){
        String del = "DELETE FROM `quotes` WHERE id = ?;";
        try {
            Connection connection = getConnection();

            PreparedStatement prSt = null;
            String insert;
            if(UserData.user.getClaster().equals("admin")){
                insert ="DELETE FROM `quotes` WHERE id = ?;";
                prSt = connection.prepareStatement(insert);
            } else if(UserData.user.getClaster().equals("student")) {
                insert ="DELETE FROM `quotes` WHERE id = ? and id_user = ?;";
                prSt = connection.prepareStatement(insert);
                prSt.setInt(2, UserData.user.getId());
            } else if(UserData.user.getClaster().equals("starosta")) {
                insert = "DELETE FROM `quotes` WHERE id = ? and user_group = ?;";
                prSt = connection.prepareStatement(insert);
                prSt.setString(2, UserData.user.getGroup());
            }

            prSt.setInt(1, id);
            prSt.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
