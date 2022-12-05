
import Stocks.Amazon;
import Stocks.Meta;
import User.User;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
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
    }
    
}