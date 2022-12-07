package Command;

import Stocks.StocksData;
import User.User;

public class buyCommand implements Command {

    private User user;

    public buyCommand(User user) {
        this.user = user;
    }

    public void execute(StocksData stock, double amount, String date) {
        user.buyStocks(stock, amount, date);
    }
}
