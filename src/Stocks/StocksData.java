package Stocks;

import Iterator.ReadFile;

import java.io.*;
import java.util.Objects;

public abstract class StocksData {
    private ReadFile read;

    public StocksData() throws IOException {
        read = new ReadFile("./Stocks Data/" + getName() + ".csv");
    }


    public abstract String getName();

    public double getPrice(String date) {
        return Double.parseDouble(read.dayInfo(date).get("Close/Last").substring(1));
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
        return getName() != null ? getName().hashCode() : 0;
    }
}

