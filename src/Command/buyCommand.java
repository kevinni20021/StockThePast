package Command;

import Stocks.StocksData;
import User.User;


/**
 * A class responsible for buying stock
 */
public class buyCommand implements Command {


    private User user;

    public buyCommand(User user) {
        this.user = user;
    }

    /**
     * This method is responsible for buying stock
     * @param stock the stock to buy
     * @param amount the amount to buy
     * @param date the date to buy
     */
    public void execute(StocksData stock, double amount, String date) {
        user.buyStocks(stock, amount, date);
    }
}
