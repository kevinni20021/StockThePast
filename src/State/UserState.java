package State;

import Command.*;
import LoginSystem.LoginSystem;
import Stocks.*;
import User.User;

public class UserState implements State {

    private LoginSystem users;
    private User user;

    public UserState(LoginSystem system) {
        this.users = system;
    }

    public void getUser(String username, String password) {
        this.user = users.login(username, password).getUser();
    }

    public String getState(){
        return "UserState";
    }
}
