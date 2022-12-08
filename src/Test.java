import Iterator.*;
import Stocks.*;
import Command.*;
import User.*;
import LoginSystem.*;

import java.util.*;
import java.io.*;

/**
 * This class is completely used for testing, not related to main program
 */
public class Test {
    public static void main(String[] args) throws IOException{
        //Sanity check for Iterator
        String name = "Apple";
        ReadFile read = new ReadFile("./Stocks Data/" + name + ".csv");
        ReadFileCollection rFile = new ReadFileCollection("./Stocks Data/" + name + ".csv");
        ReadFile temp = rFile.createIterator();
        while (temp.hasNextDay()) {
            System.out.println(temp.curMonth + "/" + temp.curDay + "/" + temp.curYear);
            System.out.println("Value for that key = " + temp.dayInfo(temp.curDay, temp.curMonth, temp.curYear));
            temp.getNextDay();
        }
        System.out.println(temp.curMonth + "/" + temp.curDay + "/" + temp.curYear);
        System.out.println("Value for that key = " + temp.dayInfo(temp.curDay, temp.curMonth, temp.curYear));

        //Sanity Check for buying and selling stocks
        Amazon a = new Amazon();
        Meta m = new Meta();
        User user = new User("David", "hudavid6");
        user.addBalance(3000);
        user.buyStocks(a, 5, "11/11/2022");
        user.buyStocks(a, 20, "11/14/2022");
        user.sellStocks(a, 6, "11/16/2022");
        user.buyStocks(m, 5, "11/17/2022");
        user.sellStocks(a, 40, "11/17/2022");
        System.out.println(user.stocksOwned);
        System.out.println(user.getNW("11/18/2022"));
        System.out.println(user.getROI("11/18/2022"));

        //Sanity Check for login System
        LoginSystem test = new LoginSystem();
        test.login("Kevin", "123");
        test.createAccount("Kevin", "1234");
        test.login("Kevin", "1234");
        test.logout();
        test.createAccount("Kevin", "1234");
        test.logout();
        test.login("Kevin", "1234");
    }
}

