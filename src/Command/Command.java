package Command;

import src.StocksData;

public interface Command {
    void execute(StocksData stock, double amount, String date);
}
