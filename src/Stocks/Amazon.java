package Stocks;

import java.io.IOException;

public class Amazon extends StocksData {
    public Amazon() throws IOException {
        super();
    }

    @Override
    public String getName() {
        return "Amazon";
    }
}
