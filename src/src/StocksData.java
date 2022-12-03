package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import Iterator.ReadFile;

public abstract class StocksData {
    //private final HashMap<String, Double> data;
    private ReadFile read;

    public StocksData() throws IOException {
        //read = new ReadFile("C:\\Users\\CGOD\\Desktop\\University\\Second year\\First Semester\\CSC207\\StockThePast\\Stocks Data\\" + getName() + ".csv");
        read = new ReadFile("./Stocks Data/" + getName() + ".csv");

//        }
    }

    public abstract String getName();

    public double getPrice(String date) {
        return Double.parseDouble(read.dayInfo(date).get("Close/Last").substring(1));
    }
}
