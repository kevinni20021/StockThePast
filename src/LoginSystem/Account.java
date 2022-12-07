package LoginSystem;
import User.User;

public class Account {
    private String password;
    private String username;
    private User user;
    private boolean loggedin = false;

    public Account(String username, String password) {
        this.user = new User("", username);
        this.username = username;
        this.password = password;
    }

    public void logout() {
        this.loggedin = false;
    }
    public boolean isLoggedin() {
        return loggedin;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public User getUser(){return this.user;}

    public void login() {
        this.loggedin = true;
    }

    public void setPassword(String password) {
        if (this.isLoggedin()){
            this.password = password;
        }
    }

    public void setName(String name) {
        if (this.isLoggedin()){
            this.getUser().setName(name);
        }
    }

    public void setUsername(String username) {
        if (this.isLoggedin()){
            this.username = username;
            //User.User class will change username here
        }
    }
}
