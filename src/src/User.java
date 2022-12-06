package src;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * This is the main class for the backend logistics
 * Every backend classes are connected to this class
 */
public class User {
    public HashMap<StocksData, ArrayList<ArrayList<Object>>> stocksOwned;
    private double balance;
    private String name;
    private String userID;

    private double ROI;

    /**
     * This constructor is responsible for initializing a user's account
     * @param name the user's name
     * @param userID the user's ID
     */
    public User(String name, String userID) {
        this.name = name;
        this.userID = userID;
        this.stocksOwned = new HashMap<>();
    }

    /**
     * This method is responsible for buying stocks
     *
     * @param stock the stock being purchased
     * @param amount number of stocks being purchased
     * @param date date of purchase
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
        } else {
            System.out.println("Insufficient funds");
        }
    }

    /**
     * This method is responsible for selling stocks
     *
     * @param stock the stock being sold
     * @param amount number of stocks being sold
     * @param date sold date
     */
    public void sellStocks(StocksData stock, double amount, String date) {
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
    }

    /**
     * This method is responsible for getting net worth
     *
     * @param date the date requested for net worth
     * @return net worth
     */
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

    /**
     * This method is responsible for getting return on investments
     *
     * @param date the date requested for ROI
     * @return list of ROI's for each stock
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
            double ROI = totalReturn * stock.getPrice(date) - invested;
            currROI.add(stock.getName() + " = " + ROI + "");
        }
        return currROI;
    }

    /**
     * This method is responsible for adding balance
     *
     * @param amount the amount being added to balance
     */
    public void addBalance(double amount) {
        balance += amount;
    }

    public void setName(String name) {
        this.name = name;
    }

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
