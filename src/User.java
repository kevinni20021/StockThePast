package src;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    public HashMap<StocksData, ArrayList<ArrayList<Object>>> stocksOwned;
    private double balance;
    private String name;
    private String userID;

    private double ROI;

    private boolean status;
    public User(String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.stocksOwned = new HashMap<>();
    }

    public void buyStocks(StocksData stock, double amount, String date) {
        if (balance - amount * stock.getPrice(date) > 0) {
            balance -= amount * stock.getPrice(date);
            ArrayList<Object> data = new ArrayList<Object>();
            data.add(stock.getPrice(date));
            data.add(amount);
            data.add(date);
            if (stocksOwned.containsKey(stock)) {
                stocksOwned.get(stock).add(data);
            } else {
                stocksOwned.put(stock, new ArrayList<>());
                stocksOwned.get(stock).add(data);
            }
            status = true;
        }
        else {
            status = false;
        }
    }

    public void sellStocks(StocksData stock, double amount, String date) {
        double numStocks = 0;
        for (ArrayList<Object> stockData : stocksOwned.get(stock)) {
            numStocks += (double) stockData.get(1);
        }
        if (numStocks - amount >= 0) {
            balance += stock.getPrice(date) * amount;
            ArrayList<Object> data = new ArrayList<Object>();
            data.add(stock.getPrice(date));
            data.add(-amount);
            data.add(date);
            if (stocksOwned.containsKey(stock)) {
                stocksOwned.get(stock).add(data);
            } else {
                stocksOwned.put(stock, new ArrayList<>());
                stocksOwned.get(stock).add(data);
            }
            status = true;
        }
        else {
            status = false;
        }
    }

    public double getNW(String date) {
        double result = 0;
        for (StocksData stock : stocksOwned.keySet()) {
            double numStocks = 0;
            for (ArrayList<Object> stockData : stocksOwned.get(stock)) {
                numStocks += (double) stockData.get(1);
            }
            result += stock.getPrice(date) * numStocks;
        }
        return result + balance;
    }

    public ArrayList<String> getROI(String date) {
        ArrayList<String> currROI = new ArrayList<>();
        for (StocksData stock : stocksOwned.keySet()) {
            double invested = 0;
            double totalReturn = 0;
            for (ArrayList<Object> stockData : stocksOwned.get(stock)) {
                invested += (double) stockData.get(0) * (double) stockData.get(1);
                totalReturn += (double) stockData.get(1);
            }
            double ROI = totalReturn * stock.getPrice(date) - invested;
            currROI.add(stock.getName() + " = " + ROI + "");
        }
        return currROI;
    }

    public double getBalance() {return balance;}
    public void addBalance(double amount) {
        balance += amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {return status;}
}
