package sample.courseproject2;

public class User {

//    private int id;
    private String login;
    private String password;
    private String claster;

    public User(String login, String password, String claster) {
//        this.id = id;
        this.login = login;
        this.password = password;
        this.claster = claster;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClaster() {
        return claster;
    }

    public void setClaster(String email) {
        this.claster = claster;
    }
}