package src;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StocksData that = (StocksData) o;

        return Objects.equals(that.getName(), getName());
    }

    @Override
    public int hashCode() {
        return data != null ? data.hashCode() : 0;
    }
}
