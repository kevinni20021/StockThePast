package src;

import java.io.*;
import java.util.HashMap;

abstract class StocksData {
    private final HashMap<String, Double> data;

    public StocksData() throws IOException {
        this.data = new HashMap<>();
        BufferedReader file = new BufferedReader(new FileReader("./stocksdata/" + getName() + ".csv"));
        file.readLine();
        String line;
        while ((line = file.readLine()) != null) {
            String[] curr = line.split(",");
            data.put(curr[0], Double.parseDouble(curr[1].substring(1)));
        }
    }

    public abstract String getName();

    public double getPrice(String date) {
        return data.get(date);
    }
}