package src;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        src.Amazon a = new src.Amazon();
        src.Meta m = new src.Meta();
        src.User user = new src.User("David", "hudavid6");
        user.addBalance(3000);
        user.buyStocks(a, 5, "11/11/2022");
        user.buyStocks(a, 20, "11/14/2022");
        user.sellStocks(a, 6, "11/16/2022");
        user.buyStocks(m, 5, "11/17/2022");
        System.out.println(user.stocksOwned);
        System.out.println(user.getNW("11/18/2022"));
        System.out.println(user.getROI("11/18/2022"));
    }

}
