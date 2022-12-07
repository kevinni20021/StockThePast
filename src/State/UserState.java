package State;

import Command.*;
import LoginSystem.LoginSystem;
import Stocks.*;
import User.User;


/**
 * This is the state for the user page
 */
public class UserState implements State {

    private LoginSystem users;
    private User user;


    /**
     * This is the constructor for the class, which it takes in a LoginSystem as the parameter
     * @param system the LoginSystem used in this class
     */
    public UserState(LoginSystem system) {
        this.users = system;
    }


    /**
     * This is a setter method for the users
     * @param username the username to set
     * @param password the password to set
     */
    public void getUser(String username, String password) {
        this.user = users.login(username, password).getUser();
    }


    /**
     * This is a getter method for the current state
     * @return the current state
     */
    public String getState(){
        return "UserState";
    }
}
