package views;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class StockView {

    Stage stage;

    Button loginButton, createAccountButton;
    BorderPane borderPane;
    Canvas canvas;
    GraphicsContext gc; //the graphics context will be linked to the canvas

    private int buttonLength = 150;
    private int buttonWidth = 50;

    public final int fontSizeDefault = 20;

    //Error Label
    private Label errorLabel = new Label("");

    //Titles
    private Label title = new Label(String.format("Welcome to Stock The Past"));

    //Labels for username and password
    Label username = new Label("Username");
    Label password = new Label("Password");

    //TextFields
    private TextField usernameField = new TextField("");
    private PasswordField passwordField = new PasswordField();

    //Will start on the login page
    public StockView(Stage stage) {
        this.stage = stage;
        initUI();
    }

    private void initUI(){
        this.stage.setTitle("Stock the Past");
        borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #121212;");

        //Colors, sizing and initializer for Login and Create account
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
        createAccountButton.setOnAction(e -> newCreateAccView());

        //Username and password fields
        usernameField.setMaxWidth(400);
        usernameField.setId("usernameField");
        usernameField.setPromptText("Enter Username");
        usernameField.setStyle("-fx-text-fill: #e8e6e3;");
        usernameField.setFont(new Font(fontSizeDefault));

        passwordField.setMaxWidth(400);
        passwordField.setId("passwordField");
        passwordField.setPromptText("Enter Password");
        passwordField.setStyle("-fx-text-fill: #e8e6e3;");
        passwordField.setFont(new Font(fontSizeDefault));


        //Title and other text init
        title.setId("title");
        title.setFont(new Font(30));
        title.setStyle("-fx-text-fill: white;");

        errorLabel.setId("error");
        errorLabel.setStyle("-fx-text-fill: #e8e6e3;");
        errorLabel.setFont(new Font(fontSizeDefault));

        //temporary will add in backend later
        errorLabel.setText("Login System on Maintenence");

        //Aliignment for buttons and text fields
        HBox loginSystemButtons = new HBox(100, loginButton, createAccountButton);
        loginSystemButtons.setAlignment(Pos.CENTER);

        //Allignment for the entire page
        VBox loginPage = new VBox(10, title, usernameField, passwordField, loginSystemButtons, errorLabel);
        loginPage.setAlignment(Pos.CENTER);
        borderPane.setCenter(loginPage);

        canvas = new Canvas(500, 500);
        canvas.setId("Canvas");
        gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(borderPane, 500, 500);
        this.stage.setScene(scene);
        this.stage.show();
    }

    private void newCreateAccView() {
        CreateAccView createAccView = new CreateAccView(this);
    }
}
