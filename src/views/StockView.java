package views;

import LoginSystem.LoginSystem;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import Iterator.ReadFile;
import LoginSystem.LoginSystem;
import Stocks.StockFactory;
import User.User;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class StockView {

    private User user;

    private TextField addBalanceTextField = new TextField("");

    public ReadFile date;

    StockFactory stockFactory = new StockFactory();
    Button addButton, buyButton, sellButton, ROIButton, historyButton, nextButton;

    Label balanceLabel = new Label();
    Label dateLabel = new Label();

    BorderPane borderPane;

    Stage stage;

    LoginSystem loginSystem;

    Button loginButton, createAccountButton, createButton, backButton;
    Canvas canvas;
    GraphicsContext gc; //the graphics context will be linked to the canvas

    Button logoutButton, accessibilityButton;

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
    private TextField newusernameField = new TextField("");
    private PasswordField newpasswordField = new PasswordField();
    private PasswordField confirmpasswordField = new PasswordField();


    XYChart.Series<String, Number> graphAmazon = new XYChart.Series<>();

    XYChart.Series<String, Number> graphApple = new XYChart.Series<>();

    XYChart.Series<String, Number> graphMeta = new XYChart.Series<>();

    XYChart.Series<String, Number> graphMicrosoft = new XYChart.Series<>();

    XYChart.Series<String, Number> graphStarBucks = new XYChart.Series<>();

    XYChart.Series<String, Number> graphTesla = new XYChart.Series<>();

    public StockView(Stage primaryStage, LoginSystem loginSystem) {
        this.stage = primaryStage;
        this.loginSystem = loginSystem;
        initUI();
    }
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

        newpasswordField.setId("newpasswordField");
        newpasswordField.setPromptText("New Password");
        newpasswordField.setMaxWidth(400);
        newpasswordField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        newpasswordField.setFont(new Font(fontSizeDefault));

        newusernameField.setId("newusernameField");
        newusernameField.setPromptText("New Username");
        newusernameField.setMaxWidth(400);
        newusernameField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        newusernameField.setFont(new Font(fontSizeDefault));

        confirmpasswordField.setId("confirmpasswordField");
        confirmpasswordField.setPromptText("Confirm Password");
        confirmpasswordField.setMaxWidth(400);
        confirmpasswordField.setStyle("-fx-text-fill: #e8e6e3; -fx-text-fill: black;");
        confirmpasswordField.setFont(new Font(fontSizeDefault));

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
        VBox createPage = new VBox(10, createTitle, newusernameField, newpasswordField, confirmpasswordField, createAccountButtons, createAccountError);

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

    //Methods to switch views
    private void CreateAccView(VBox createPage, VBox loginpage) {
        loginpage.setVisible(false);
        createPage.setVisible(true);
        createPage.setAlignment(Pos.CENTER);
        borderPane.setCenter(createPage);
    }

    private void loginView(VBox createPage, VBox loginpage){
        loginpage.setVisible(true);
        createPage.setVisible(false);
        loginpage.setAlignment(Pos.CENTER);
        borderPane.setCenter(loginpage);
    }

    //Backend methods go here
    private void loginAccount(){
        String username = this.usernameField.getText();
        String password = this.passwordField.getText();
        if (this.loginSystem.login(username, password) != null){
            this.user = this.loginSystem.getAccount().getUser();
            activateStocks();
        } else {
            this.errorLabel.setText(this.loginSystem.errorMsg);
            this.loginSystem.logout();
        }
//        String password = this.usernameField.getText();
//        String username = this.passwordField.getText();
//        this.loginSystem.login(username, password);
    }

    private void createAccount(){
        String newpassword = this.newpasswordField.getText();
        String confirmpassword = this.confirmpasswordField.getText();
        String newusername = this.newusernameField.getText();
        if (!Objects.equals(newpassword, confirmpassword)){
            this.createAccountError.setText("Passwords do not match, please try again");
        } else {
            this.loginSystem.createAccount(newusername,newpassword);
        }
    }

    private void activateStocks(){
        borderPane = new BorderPane();

        date = new ReadFile("./Stocks Data/Amazon.csv");

        addButton = new Button("Add Balance");
        addButton.setId("AddBalance");
        addButton.setPrefSize(80, 50);
        addButton.setFont(new Font(12));
        addButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        addButton.setOnAction(e -> {
            createAddView();
            borderPane.requestFocus();
        });

        buyButton = new Button("Buy");
        buyButton.setId("Buy");
        buyButton.setPrefSize(80, 50);
        buyButton.setFont(new Font(12));
        buyButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        buyButton.setOnAction(e -> {
            createBuyView();
            borderPane.requestFocus();
        });

        sellButton = new Button("Sell");
        sellButton.setId("Sell");
        sellButton.setPrefSize(80, 50);
        sellButton.setFont(new Font(12));
        sellButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        sellButton.setOnAction(e -> {
            createSellView();
            borderPane.requestFocus();
        });

        ROIButton = new Button("ROI");
        ROIButton.setId("ROI");
        ROIButton.setPrefSize(80, 50);
        ROIButton.setFont(new Font(12));
        ROIButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        ROIButton.setOnAction(e -> {
            createROIView();
            borderPane.requestFocus();
        });

        historyButton = new Button("History");
        historyButton.setId("History");
        historyButton.setPrefSize(80, 50);
        historyButton.setFont(new Font(12));
        historyButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        historyButton.setOnAction(e -> {
            createHistoryView();
            borderPane.requestFocus();
        });

        nextButton = new Button("Next Day");
        nextButton.setId("nextDay");
        nextButton.setPrefSize(80, 50);
        nextButton.setFont(new Font(12));
        nextButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        logoutButton = new Button("Logout");
        logoutButton.setId("logoutButton");
        logoutButton.setPrefSize(100, 50);
        logoutButton.setFont(new Font(12));
        logoutButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        accessibilityButton = new Button("Accessibility");
        accessibilityButton.setId("accessibility");
        accessibilityButton.setPrefSize(100, 50);
        accessibilityButton.setFont(new Font(12));
        accessibilityButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        accessibilityButton.setOnAction(e -> createAccessibilityView());
        logoutButton.setOnAction(e -> logout());

        nextButton.setOnAction(e -> {
            date.getNextDay();
            dateLabel.setText("Date: " + date.getCurrDay());
            nextDay();
            borderPane.requestFocus();
        });

        balanceLabel.setId("balanceLabel");
        balanceLabel.setText("Balance: " + user.getBalance());
        balanceLabel.setMinWidth(200);
        balanceLabel.setFont(new Font(16));
        balanceLabel.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        dateLabel.setId("dateLabel");
        dateLabel.setText("Date: " + date.getCurrDay());
        dateLabel.setMinWidth(125);
        dateLabel.setFont(new Font(16));
        dateLabel.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        HBox controls = new HBox(20, dateLabel, balanceLabel, nextButton, addButton, buyButton, sellButton, ROIButton, historyButton);
        controls.setPadding(new Insets(20, 20, 20, 20));
        controls.setAlignment(Pos.CENTER);

        HBox logaccbuttons = new HBox(800, accessibilityButton, logoutButton);
        logaccbuttons.setAlignment(Pos.CENTER);

        Group root = new Group();

        CategoryAxis x = new CategoryAxis();
        x.setLabel("Days");

        NumberAxis y = new NumberAxis();
        y.setLabel("Price");

        LineChart<String, Number> line = new LineChart<String, Number>(x, y);
        line.setPrefSize(1000, 600);

        nextDay();
        graphAmazon.setName("Amazon");
        graphApple.setName("Apple");
        graphMeta.setName("Meta");
        graphMicrosoft.setName("Microsoft");
        graphStarBucks.setName("StarBucks");
        graphTesla.setName("Tesla");

        line.getData().addAll(graphAmazon, graphApple, graphMeta, graphMicrosoft, graphStarBucks, graphTesla);
        root.getChildren().add(line);

        borderPane.setTop(controls);
        borderPane.setCenter(root);
        borderPane.setBottom(logaccbuttons);

        Scene scene = new Scene(borderPane, 1000, 800);
        stage.setScene(scene);
        stage.show();

    }

    private void nextDay() {
        try {
            if (graphAmazon.getData().size() == 30) {
                graphAmazon.getData().remove(0);
                graphApple.getData().remove(0);
                graphMeta.getData().remove(0);
                graphMicrosoft.getData().remove(0);
                graphStarBucks.getData().remove(0);
                graphTesla.getData().remove(0);
            }
            graphAmazon.getData().add(new XYChart.Data<String, Number>(date.getCurrDay(), stockFactory.getStock("Amazon").getPrice(date.getCurrDay())));
            graphApple.getData().add(new XYChart.Data<String, Number>(date.getCurrDay(), stockFactory.getStock("Apple").getPrice(date.getCurrDay())));
            graphMeta.getData().add(new XYChart.Data<String, Number>(date.getCurrDay(), stockFactory.getStock("Meta").getPrice(date.getCurrDay())));
            graphMicrosoft.getData().add(new XYChart.Data<String, Number>(date.getCurrDay(), stockFactory.getStock("Microsoft").getPrice(date.getCurrDay())));
            graphStarBucks.getData().add(new XYChart.Data<String, Number>(date.getCurrDay(), stockFactory.getStock("StarBucks").getPrice(date.getCurrDay())));
            graphTesla.getData().add(new XYChart.Data<String, Number>(date.getCurrDay(), stockFactory.getStock("Tesla").getPrice(date.getCurrDay())));
        }
        catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void createAddView() {AddView addView = new AddView(user, balanceLabel);}

    private void createBuyView(){ BuyView buyView = new BuyView(user, balanceLabel, date.getCurrDay()); }

    private void createSellView(){
        SellView sellView = new SellView(user, balanceLabel, date.getCurrDay());
    }

    private void createROIView() {ROIView roiView = new ROIView(user, date.getCurrDay());}

    private void createHistoryView() {HistoryView historyView = new HistoryView(user);}

    private void createAccessibilityView() {AccessibilityView accessibilityView = new AccessibilityView();}

    private void clearLabels() {
        errorLabel.setText("");
        createAccountError.setText("");
        confirmpasswordField.setText("");
        usernameField.setText("");
        newusernameField.setText("");
        newpasswordField.setText("");
        createAccountError.setText("");
        passwordField.setText("");
    }

    private void logout() {
        this.loginSystem.logout();
        this.clearLabels();
        initUI();
    }
}
