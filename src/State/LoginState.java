package State;

import LoginSystem.LoginSystem;


/**
 * This is the state for the login page
 */
public class LoginState implements State {

    private LoginSystem users;


    /**
     * This is the constructor for the class, which it takes in a LoginSystem as the parameter
     * @param system the LoginSystem used in this class
     */
    public LoginState(LoginSystem system) {
        this.users = system;
    }


    /**
     * This is a setter method for the users
     * @param username the username to set
     * @param password the password to set
     */
    public void getUser(String username, String password) {
        users.login(username, password);
    }


    /**
     * This is a getter method for the current state
     * @return the current state
     */
    public String getState(){
        return "LoginState";
    }

}
