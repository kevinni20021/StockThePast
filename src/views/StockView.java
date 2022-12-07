package views;

import LoginSystem.LoginSystem;
import User.User;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class StockView {

    public static Stage stage;

    public static LoginSystem system;

    private static HashMap<String, UserView> userViews;

    public StockView(Stage primaryStage, LoginSystem loginSystem) {
        userViews = new HashMap<>();
        stage = primaryStage;
        system = loginSystem;
        LoginView loginView = new LoginView(stage, system);
    }

    static void logout() {
        system.logout();
        LoginView login = new LoginView(stage, system);
    }

    static void activateStocks(User user) {
        if (userViews.containsKey(user.getUserID())) {
            userViews.get(user.getUserID()).initUI();
        }
        else {
            UserView view = new UserView(user, stage);
            userViews.put(user.getUserID(), view);
        }
    }
}
