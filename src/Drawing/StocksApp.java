package Drawing;

import javafx.application.Application;
import javafx.stage.Stage;

public class StocksApp extends Application {
    StocksModel model;
    StocksView view;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.model = new StocksModel(); // create a model
        this.view = new StocksView(model, primaryStage); //tie the model to the view
        this.model.startGame(); //begin
    }

}
