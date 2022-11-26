package LoginSystem;

public class Account {
    private String password;
    private String username;
    //private User user;
    private boolean loggedin = false;

    public boolean isLoggedin() {
        return loggedin;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setLoggedin(boolean loggedin) {
        this.loggedin = loggedin;
    }

    public void setPassword(String password) {
        if (this.isLoggedin()){
            this.password = password;
        }
    }

    public void setUsername(String username) {
        if (this.isLoggedin()){
            this.username = username;
            //User class will change username here
        }
    }
}
