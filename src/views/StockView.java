package views;

import LoginSystem.LoginSystem;
import User.User;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * This class is responsible for the main page of the application
 */
public class StockView {

    public static Stage stage;

    public static LoginSystem system;

    private static HashMap<String, UserView> userViews;


    /**
     * The constructor to call when opening the main page of the application
     * @param primaryStage the primary stage to set to
     * @param loginSystem the loginSystem implemented from backend
     */
    public StockView(Stage primaryStage, LoginSystem loginSystem) {
        userViews = new HashMap<>();
        stage = primaryStage;
        system = loginSystem;
        LoginView loginView = new LoginView(stage, system);
    }


    /**
     * This method is responsible for loging the user out
     */
    static void logout() {
        system.logout();
        LoginView login = new LoginView(stage, system);
    }


    /**
     * This method brings the application to the main stocks page
     */
    static void activateStocks(User user) {
        if (userViews.containsKey(user.getUserID())) {
            userViews.get(user.getUserID()).initUI();
        }
        else {
            iew);
        }
    }
}
