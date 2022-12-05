package Command;

import Stocks.StocksData;

public interface Command {
    void execute(StocksData stock, double amount, String date);
}
