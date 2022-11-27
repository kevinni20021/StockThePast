package Command;

public class buyCommand implements Command {
    private Stock stock;

    public void buyStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.buy();

    }
}
