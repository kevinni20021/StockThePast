package Stocks;

import java.io.IOException;


/**
 * This class is responsible for getting the stock class corresponding to the name given
 */
public class StockFactory {


    /**
     * THis is the class that returns the corresponding class by the given file name
     * @param name the given file name
     * @return the file class corresponding to that name
     * @throws IOException
     */
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
