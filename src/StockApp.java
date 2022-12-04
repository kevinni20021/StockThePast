import javafx.application.Application;
import javafx.stage.Stage;
import views.StockView;

public class StockApp extends Application{
    StockView view;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.view = new StockView(primaryStage); //tie the model to the view
    }
}
