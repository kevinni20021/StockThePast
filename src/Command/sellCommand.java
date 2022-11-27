package Command;

public class sellCommand implements Command {

    private Stock stock;

    public void sellStock(Stock stock) {
        this.stock = stock;
    }

    public void execute() {
        stock.sell();

    }
}
