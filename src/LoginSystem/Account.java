package LoginSystem;
import src.User;


/**
 * This class is responsible for storing the data from the user
 */
public class Account {
    private String password;
    private String username;
    private User user;
    private boolean loggedin = false;


    /**
     * This constructor takes in the username and the password that the user provided
     * @param username the username that the user provided when this class is called
     * @param password the password that the user provided when this class is called
     */
    public Account(String username, String password) {
        this.user = new User("", username);
        this.username = username;
        this.password = password;
    }


    /**
     * This method will log out the user
     */
    public void logout() {
        this.loggedin = false;
    }


    /**
     * This method will determine whether the current user is logged in or not
     * @return true if the user is logged in, false otherwise
     */
    public boolean isLoggedin() {
        return loggedin;
    }


    /**
     * This is a getter method to get the passport of this user
     */
    public String getPassword() {
        return password;
    }


    /**
     * This is a getter method to get the username of this user
     */
    public String getUsername() {
        return username;
    }


    /**
     * This is a getter method to get the user object of this user
     */
    public User getUser(){return this.user;}


    /**
     * This is a setter method to sign in the user
     */
    public void login() {
        this.loggedin = true;
    }


    /**
     * This is a setter method to set the user's password
     * @param password the password the user wants to set to
     */
    public void setPassword(String password) {
        if (this.isLoggedin()){
            this.password = password;
        }
    }


    /**
     * This is a setter method to set the user's name
     * @param name the name the user wants to set to
     */
    public void setName(String name) {
        if (this.isLoggedin()){
            this.getUser().setName(name);
        }
    }


    /**
     * This is a setter method to set the user's username
     * @param username the username the user wants to set to
     */
    public void setUsername(String username) {
        if (this.isLoggedin()){
            this.username = username;
            //User class will change username here
        }
    }
}
