package src.State;

import src.LoginSystem.LoginSystem;

public class LoginState implements State {

    private LoginSystem users;

    public LoginState(LoginSystem system) {
        this.users = system;
    }

    public void getUser(String username, String password) {
        users.login(username, password);
    }

    public String getState(){
        return "LoginState";
    }

}
