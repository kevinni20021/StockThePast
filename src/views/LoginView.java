package views;
import LoginSystem.LoginSystem;
import User.User;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Objects;


/**
 * This class is responsible for the login page of the application
 */
public class LoginView {
    User user;

    Stage stage;
    LoginSystem loginSystem;

    Button loginButton, createAccountButton, createButton, backButton;
    BorderPane borderPane;
    Canvas canvas;
    GraphicsContext gc; //the graphics context will be linked to the canvas

    private int buttonLength = 150;
    private int buttonWidth = 50;

    public final int fontSizeDefault = 20;

    //Error Label
    private Label errorLabel = new Label("");
    private Label createAccountError = new Label("");

    //Titles
    private Label title = new Label(String.format("Welcome to Stock The Past"));
    //I got lazy
    private Label createTitle = new Label(String.format("Create New Account"));

    //TextFields
    private TextField usernameField = new TextField("");
    private PasswordField passwordField = new PasswordField();

    //TextField for username and password for create Account
    private TextField newUsernameField = new TextField("");
    private PasswordField newPasswordField = new PasswordField();
    private PasswordField confirmPasswordField = new PasswordField();



    /**
     * The constructor of the Login page
     * This the first page that the applcation will open
     * @param stage the stage of the page
     * @param loginSystem the loginSystem implemented from backend
     */
    public LoginView(Stage stage, LoginSystem loginSystem) {
        this.stage = stage;
        this.loginSystem = loginSystem;
        initUI();
    }


    /**
     * Main code for the page
     */
    private void initUI(){
        this.stage.setTitle("Stock the Past");
        borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #121212;");

        //Login Page stuff
        //Colors, sizing and initializer for Login and Create account button
        loginButton = new Button("Login");
        loginButton.setId("Login");
        loginButton.setPrefSize(buttonLength, buttonWidth);
        loginButton.setFont(new Font(fontSizeDefault));
        loginButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        createAccountButton = new Button("New Account");
        createAccountButton.setId("New Account");
        createAccountButton.setPrefSize(buttonLength, buttonWidth);
        createAccountButton.setFont(new Font(fontSizeDefault));
        createAccountButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        //Username and password fields
        usernameField.setMaxWidth(400);
        usernameField.setId("usernameField");
        usernameField.setPromptText("Enter Username");
        usernameField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        usernameField.setFont(new Font(fontSizeDefault));

        passwordField.setMaxWidth(400);
        passwordField.setId("passwordField");
        passwordField.setPromptText("Enter Password");
        passwordField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        passwordField.setFont(new Font(fontSizeDefault));

        //Create Account Page Stuff
        //initialization for buttons and labels
        createAccountError.setId("createAccountError");

        newPasswordField.setId("newpasswordField");
        newPasswordField.setPromptText("New Password");
        newPasswordField.setMaxWidth(400);
        newPasswordField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        newPasswordField.setFont(new Font(fontSizeDefault));

        newUsernameField.setId("newusernameField");
        newUsernameField.setPromptText("New Username");
        newUsernameField.setMaxWidth(400);
        newUsernameField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        newUsernameField.setFont(new Font(fontSizeDefault));

        confirmPasswordField.setId("confirmpasswordField");
        confirmPasswordField.setPromptText("Confirm Password");
        confirmPasswordField.setMaxWidth(400);
        confirmPasswordField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        confirmPasswordField.setFont(new Font(fontSizeDefault));

        createButton = new Button("Create");
        createButton.setId("Create Account");
        createButton.setPrefSize(buttonLength, buttonWidth);
        createButton.setFont(new Font(fontSizeDefault));
        createButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        backButton = new Button("Back");
        backButton.setId("Back");
        backButton.setPrefSize(buttonLength, buttonWidth);
        backButton.setFont(new Font(fontSizeDefault));
        backButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        //Title and other text init
        title.setId("title");
        title.setFont(new Font(30));
        title.setStyle("-fx-text-fill: white;");
        title.setText("Welcome to Stock the Past");

        createTitle.setId("title");
        createTitle.setFont(new Font(30));
        createTitle.setStyle("-fx-text-fill: white;");
        createTitle.setText("Create New Account");

        errorLabel.setId("error");
        errorLabel.setStyle("-fx-text-fill: #e8e6e3;");
        errorLabel.setFont(new Font(fontSizeDefault));

        createAccountError.setId("create error");
        createAccountError.setStyle("-fx-text-fill: #e8e6e3;");
        createAccountError.setFont(new Font(fontSizeDefault));

        //Aliignment for buttons and text fields for login
        HBox loginSystemButtons = new HBox(100, loginButton, createAccountButton);
        loginSystemButtons.setAlignment(Pos.CENTER);

        //Allignment for buttons and text fields for create account
        HBox createAccountButtons = new HBox(100, backButton, createButton);
        createAccountButtons.setAlignment(Pos.CENTER);

        //Allignment for the entire login page
        VBox loginPage = new VBox(10, title, usernameField, passwordField, loginSystemButtons, errorLabel);

        //Allignment for the entire createa account page
        VBox createPage = new VBox(10, createTitle, newUsernameField, newPasswordField, confirmPasswordField, createAccountButtons, createAccountError);

        //Create Account page is invisible to start
        loginView(createPage, loginPage);

        //What buttons do
        createAccountButton.setOnAction(e -> CreateAccView(createPage, loginPage));
        backButton.setOnAction(e -> loginView(createPage, loginPage));
        createButton.setOnAction(e -> createAccount());
        loginButton.setOnAction(e -> loginAccount());

        canvas = new Canvas(500, 500);
        canvas.setId("Canvas");
        gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(borderPane, 500, 500);
        this.stage.setScene(scene);
        this.stage.show();
    }


    /**
     * This is the method responsible to switch views from login to create page
     * @param createPage the create page
     * @param loginpage the login page
     */
    private void CreateAccView(VBox createPage, VBox loginpage) {
        loginpage.setVisible(false);
        createPage.setVisible(true);
        createPage.setAlignment(Pos.CENTER);
        borderPane.setCenter(createPage);
    }


    /**
     * This is the method responsible to switch views from create to login page
     * @param createPage the create page
     * @param loginpage the login page
     */
    private void loginView(VBox createPage, VBox loginpage){
        loginpage.setVisible(true);
        createPage.setVisible(false);
        loginpage.setAlignment(Pos.CENTER);
        borderPane.setCenter(loginpage);
    }


    /**
     * This method implements the backend code for login system
     */
    private void loginAccount(){
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        if (this.loginSystem.login(username, password) != null){
            this.user = this.loginSystem.getAccount().getUser();
            StockView.activateStocks(this.user);
        } else {
            this.errorLabel.setText(this.loginSystem.errorMsg);
            this.loginSystem.logout();
        }
    }


    /**
     * This method implements the backend code for create account
     */
    private void createAccount(){
        String newPassword = this.newPasswordField.getText();
        String confirmPassword = this.confirmPasswordField.getText();
        String newUsername = this.newUsernameField.getText();
        if (!Objects.equals(newPassword, confirmPassword)){
            this.createAccountError.setText("Passwords do not match, please try again");
        } else if (this.loginSystem.createAccount(newUsername, newPassword) == 0) {
            this.createAccountError.setText("Username is taken");
        } else {
            this.loginSystem.createAccount(newUsername, newPassword);
            this.createAccountError.setText("Successful!");
        }
    }
}
