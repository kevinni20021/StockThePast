import LoginSystem.LoginSystem;
import javafx.application.Application;
import javafx.stage.Stage;
import views.StockView;

/**
 * This is the main class to run the application
 */
public class StockApp extends Application {

    StockView view;
    LoginSystem loginSystem;


    /**
     * The main method to run the application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }


    /**
     * Override the start method in Application from JavaFX
     * @param primaryStage the stage the application runs on
     */
    @Override
    public void start(Stage primaryStage) {
        this.loginSystem = new LoginSystem();
        this.view = new StockView(primaryStage, loginSystem);
    }
}
