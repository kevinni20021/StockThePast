package User;

import Stocks.StocksData;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.round;

public class User {
    public HashMap<StocksData, ArrayList<ArrayList<Object>>> stocksOwned;
    private double balance;
    private String name;
    private String userID;

    private double ROI;

    private double initial;

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
        double numStocks = amountOwned(stock);
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
            double numStocks = amountOwned(stock);
            result += stock.getPrice(date) * numStocks;
        }
        return Math.round((result + balance) * 100) / 100.0;
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
            if (totalReturn > 0) {
                double ROI = totalReturn * stock.getPrice(date) - invested;
                currROI.add(stock.getName() + " = " + Math.round(ROI * 100.0) / 100.0);
            }
        }
        return currROI;
    }

    public double getBalance() {return Math.round(balance * 100.0) / 100.0;}
    public void addBalance(double amount) {
        balance += Math.round(amount * 100) / 100.0;
        initial += Math.round(amount * 100) / 100.0;
    }

    public double getInitial() {return initial;}

    public String getUserID() {return userID;};

    public void setName(String name) {
        this.name = name;
    }

    public double amountOwned(StocksData stock) {
        double result = 0;
        for (ArrayList<Object> stockData : stocksOwned.get(stock)) {
            result += (double) stockData.get(1);
        }
        return result;
    }

    public boolean getStatus() {return status;}

    public HashMap<StocksData, ArrayList<ArrayList<Object>>> getStocksOwned() {
        return this.stocksOwned;
    }

    // Returns a dictionary of stockname, then its date as the key and double as the value to graph
    public HashMap<String, HashMap<String, Double>> stockDate(User user) {
        // Want to get a dictionary of all the days for which the user owns the stock to graph their changes
        HashMap<String, HashMap<String, Double>> hack = new HashMap<String, HashMap<String, Double>>();
        for (StocksData stock : user.getStocksOwned().keySet()) {
            for (ArrayList<Object> stockData : user.getStocksOwned().get(stock)) {
                if (!hack.containsKey(stock.getName())) {
                    hack.put(stock.getName(), new HashMap<String, Double>());
                } else {
                    hack.get(stock.getName()).put(stockData.get(2).toString(), (double) stockData.get(0));
                }
            }
        }
        System.out.println(hack);
        return hack;
    }
}
