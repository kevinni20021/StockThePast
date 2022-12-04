package src.Command;

import src.StocksData;
import src.User;

public class sellCommand implements Command {

    private User user;

    public sellCommand(User user) {
        this.user = user;
    }

    public void execute(StocksData stock, double amount, String date) {
        user.sellStocks(stock, amount, date);
    }
}
