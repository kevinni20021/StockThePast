package User;

import Stocks.StocksData;

import java.util.ArrayList;
import java.util.HashMap;

import static java.lang.Math.round;


/**
 * This is the main user class that connects all backend code together
 * This class also controls the backend of each user
 */
public class User {
    public HashMap<StocksData, ArrayList<ArrayList<Object>>> stocksOwned;
    private double balance;
    private String name;
    private String userID;

    private double ROI;

    private double initial;

    private boolean status;


    /**
     * Create a user object based on the name and userID provided
     * @param name the user's name
     * @param userID the userID
     */
    public User(String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.stocksOwned = new HashMap<>();
    }


    /**
     * This method is responsible for buying stocks
     * @param stock the stock that the user wants to buy
     * @param amount the amount that the user wants to buy
     * @param date the date that the user wants to buy at
     */
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


    /**
     * This method is responsible for selling stocks
     * @param stock the stock that the user wants to sell
     * @param amount the amount that the user wants to sell
     * @param date the date that the user wants to sell at
     */
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


    /**
     * This method is responsible for calculating the current net worth of the user
     * @param date the date that the application is calculating this
     * @return the net worth
     */
    public double getNW(String date) {
        double result = 0;
        for (StocksData stock : stocksOwned.keySet()) {
            double numStocks = amountOwned(stock);
            result += stock.getPrice(date) * numStocks;
        }
        return Math.round((result + balance) * 100) / 100.0;
    }


    /**
     * This method is responsible for getting the Return on Investment os the user
     * @param date the date that the application is calculating this
     * @return the Return on Investment
     */
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


    /**
     * This is a getter method to get the current balance
     * @return the current balance
     */
    public double getBalance() {return Math.round(balance * 100.0) / 100.0;}


    /**
     * This is a setter method to set the balance of the user
     * @param amount the amount of balance set to the user
     */
    public void addBalance(double amount) {
        balance += Math.round(amount * 100) / 100.0;
        initial += Math.round(amount * 100) / 100.0;
    }


    /**
     * This is a getter method to get the initial balance of the user
     * @return the initial balance
     */
    public double getInitial() {return initial;}


    /**
     * This is a setter method to set a new name to the user
     * @param name the new name set to the user
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * This method is responsible to keep track of the amount of stocks that this user owns by the input stock name
     * @param stock the stock to check
     * @return the amount of stocks that this user owns on the input stock
     */
    public double amountOwned(StocksData stock) {
        double result = 0;
        for (ArrayList<Object> stockData : stocksOwned.get(stock)) {
            result += (double) stockData.get(1);
        }
        return result;
    }


    /**
     * This is a getter method to get the current status
     * @return the current status
     */
    public boolean getStatus() {return status;}


    /**
     * This is a getter method to get all the stocks that this user owns shown in a map
     * @return the map that contains all the stocks that this user owns
     */
    public HashMap<StocksData, ArrayList<ArrayList<Object>>> getStocksOwned() {
        return this.stocksOwned;
    }


    /**
     * This method is responsible for keeping track of all the dates which the user owns/buys the stock
     * @param user the specific user
     * @return a dictionary of stock name, then its date as the key and double as the value to graph
     */
    //
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
