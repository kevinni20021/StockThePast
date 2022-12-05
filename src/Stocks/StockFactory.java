package Stocks;

import java.io.IOException;

public class StockFactory {

    public StocksData getStock(String name) throws IOException {
        return switch (name) {
            case "Amazon" -> new Amazon();
            case "Apple" -> new Apple();
            case "Meta" -> new Meta();
            case "Microsoft" -> new Microsoft();
            case "StarBucks" -> new StarBucks();
            case "Tesla" -> new Tesla();
            default -> null;
        };
    }
}
