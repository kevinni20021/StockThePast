import LoginSystem.LoginSystem;
import javafx.application.Application;
import javafx.stage.Stage;
import views.StockView;

public class StockApp extends Application {

    StockView view;
    LoginSystem loginSystem;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.loginSystem = new LoginSystem();
        this.view = new StockView(primaryStage, loginSystem);
    }
}
