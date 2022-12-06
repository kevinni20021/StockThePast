package Command;

import Stocks.StocksData;
import User.User;

/**
 * A class responsible for selling stock
 */
public class sellCommand implements Command {

    private User user;


    /**
     * This method is responsible for selling stock
     * @param user the user that is doing this command
     */
    public sellCommand(User user) {
        this.user = user;
    }


    /**
     * This method is responsible for selling stock
     * @param stock the stock to buy
     * @param amount the amount to buy
     * @param date the date to buy
     */
    public void execute(StocksData stock, double amount, String date) {
        user.sellStocks(stock, amount, date);
    }
}
