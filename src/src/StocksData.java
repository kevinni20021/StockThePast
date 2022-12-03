package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public abstract class StocksData {
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
