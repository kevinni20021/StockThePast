package Stocks;

import Iterator.ReadFile;

import java.io.*;
import java.util.Objects;


/**
 * This is the parent class for all the file name classes
 */
public abstract class StocksData {
    private ReadFile read;


    /**
     * This constructor set the iterator object into the variable read with the given file name
     * @throws IOException
     */
    public StocksData() throws IOException {
        read = new ReadFile("./Stocks Data/" + getName() + ".csv");
    }


    /**
     * This is a getter method used to get the name of the file
     * @return the name of the file
     */
    public abstract String getName();


    /**
     * This method returns the price of the specific date of the current file using code in Iterator
     * @param date the given date the user wants information on
     * @return the price of that specific date
     */
    public double getPrice(String date) {
        return Double.parseDouble(read.dayInfo(date).get("Close/Last").substring(1));
    }


    /**
     * This method is used to check if the given object is the same of this object
     * @param o the given object
     * @return true if they are the same, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StocksData that = (StocksData) o;

        return Objects.equals(that.getName(), getName());
    }


    /**
     * This method returns the hashcode of the current file
     * @return the hashcode
     */
    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }
}

