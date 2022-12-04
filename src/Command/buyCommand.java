package src.Command;

import src.StocksData;
import src.User;

public class buyCommand implements Command {

    private User user;

    public buyCommand(User user) {
        this.user = user;
    }

    public void execute(StocksData stock, double amount, String date) {
        user.buyStocks(stock, amount, date);
    }
}
