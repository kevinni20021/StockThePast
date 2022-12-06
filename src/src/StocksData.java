package src;

import Iterator.ReadFile;

import java.io.IOException;


/**
 * This parent class is responsible for connecting all the stock subclass and the iterator package
 */
public abstract class StocksData {
    //private final HashMap<String, Double> data;
    private ReadFile read;


    /**
     * This constructor read the file that the user specified. Throws an exception if the input file is invalid
     * @throws IOException
     */
    public StocksData() throws IOException {
        //read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\" + getName() + ".csv");
        read = new ReadFile("./Stocks Data/" + getName() + ".csv");

//        }
    }


    /**
     * This getter method is responsible for getting the name of the file
     * @return the name of the file
     */
    public abstract String getName();


    /**
     * This getter method is responible for getting the price of the date that the user inputted
     * @param date the date that the user wants to check the information for
     * @return the information about the date inputted
     */
    public double getPrice(String date) {
        return Double.parseDouble(read.dayInfo(date).get("Close/Last").substring(1));
    }
}
