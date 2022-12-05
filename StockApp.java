import User.User;
import javafx.application.Application;
import javafx.stage.Stage;
import StockView.UserView;

public class StockApp extends Application {

    UserView view;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        User user = new User("David", "hudavid6");
        this.view = new UserView(user, primaryStage);
    }
}
