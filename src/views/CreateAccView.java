package views;

import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateAccView{

    StockView stockView;
    public CreateAccView(StockView StockView){
        this.stockView = StockView;
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stockView.stage);

    }
}
