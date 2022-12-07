import LoginSystem.LoginSystem;
import User.User;
import javafx.application.Application;
import javafx.stage.Stage;
import views.StockView;
import views.UserView;

public class StockApp extends Application {

    StockView view;
    LoginSystem loginSystem;
    private User loggedUser;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.loginSystem = new LoginSystem();
        this.view = new StockView(primaryStage,loginSystem);
    }
}
