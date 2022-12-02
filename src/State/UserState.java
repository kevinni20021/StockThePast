package src.State;

import src.Command.Command;
import src.Command.buyCommand;
import src.Command.sellCommand;
import src.LoginSystem.LoginSystem;
import src.StocksData;
import src.User;

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

    public void buy(StocksData stock, double amount, String date) {
        Command buy = new buyCommand(user);
        buy.execute(stock, amount, date);
    }

    public void sell(StocksData stock, double amount, String date) {
        Command sell = new sellCommand(user);
        sell.execute(stock, amount, date);
    }
}
