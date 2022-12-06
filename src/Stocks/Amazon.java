package Stocks;

import java.io.IOException;


/**
 * This subclass is responsible for the Amazon.csv file
 */
public class Amazon extends StocksData {


    /**
     * This constructor read the file that the user specified. Throws an exception if the input file is invalid
     * @throws IOException
     */
    public Amazon() throws IOException {
        super();
    }


    /**
     * This getter method is responsible for getting the name of the current file
     * @return the file name
     */
    @Override
    public String getName() {
        return "Amazon";
    }
}
