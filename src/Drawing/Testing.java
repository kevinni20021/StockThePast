package Drawing;

import java.io.IOException;

public class Testing {
    public static void main(String[] args) throws IOException {
        Stocks.Amazon a = new Stocks.Amazon();
        Stocks.Meta m = new Stocks.Meta();
        User.User user = new User.User("David", "hudavid6");
        user.addBalance(3000);
        user.buyStocks(a, 5, "11/11/2022");
        user.buyStocks(a, 20, "11/14/2022");
        user.sellStocks(a, 6, "11/16/2022");
        user.buyStocks(m, 5, "11/17/2022");
        StocksViewer viewer = new StocksViewer();
        user.stockDate(user);
    }
}
