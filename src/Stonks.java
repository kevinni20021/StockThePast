import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

abstract class Stocks {

    private double balance;
    private String name;
    private String userID;
    private String dob;
    private String phoneNumber;
    private boolean loginStatus;
    HashMap<String, ArrayList<Object>> stocksData;

    public Stocks() {
        this.balance = balance;
        this.name = name;
        this.userID = userID;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.loginStatus = loginStatus;
    }

    public void fileReader(String filename) {
        String line = "";
        int wordcount = 0;
        this.stocksData = new HashMap<String, ArrayList<Object>>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                ArrayList<Object> hack = new ArrayList<>(Arrays.asList(data));
                stocksData.put(filename, hack);
                wordcount++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Initialized " + wordcount + " words in the Dictionary.");
        ;
    }

}
