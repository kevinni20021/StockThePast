package Command;

import src.StocksData;


/**
 * An interface responsible for buying and selling stock
 */
public interface Command {

    /**
     * This method is responsible for buying and selling stock
     * @param stock the stock to buy
     * @param amount the amount to buy
     * @param date the date to buy
     */
    void execute(StocksData stock, double amount, String date);
}
