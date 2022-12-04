package src.StockView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import src.User;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class UserView {

    private User user;

    private double width;

    private double height;

    private TextField addBalanceTextField = new TextField("");

    Button addButton, buyButton, sellButton, ROIButton, historyButton;

    Label balanceLabel = new Label();

    BorderPane borderPane;

    Stage stage;


    public UserView(User user, Stage primaryStage) {
        this.user = user;
        this.stage = primaryStage;
        initUI();
    }

    private void initUI() {
        stage.setTitle("CSC207 StockThePast");
        borderPane = new BorderPane();

        addButton = new Button("Add Balance");
        addButton.setId("AddBalance");
        addButton.setPrefSize(100, 50);
        addButton.setFont(new Font(12));
        addButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        addButton.setOnAction(e -> {
            createAddView();
            borderPane.requestFocus();
        });

        buyButton = new Button("Buy");
        buyButton.setId("Buy");
        buyButton.setPrefSize(100, 50);
        buyButton.setFont(new Font(12));
        buyButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        buyButton.setOnAction(e -> {
            createBuyView();
            borderPane.requestFocus();
        });

        sellButton = new Button("Sell");
        sellButton.setId("Sell");
        sellButton.setPrefSize(100, 50);
        sellButton.setFont(new Font(12));
        sellButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        sellButton.setOnAction(e -> {
            createSellView();
            borderPane.requestFocus();
        });

        ROIButton = new Button("ROI");
        ROIButton.setId("ROI");
        ROIButton.setPrefSize(100, 50);
        ROIButton.setFont(new Font(12));
        ROIButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        ROIButton.setOnAction(e -> {
            createROIView();
            borderPane.requestFocus();
        });

        historyButton = new Button("History");
        historyButton.setId("History");
        historyButton.setPrefSize(100, 50);
        historyButton.setFont(new Font(12));
        historyButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        historyButton.setOnAction(e -> {
            createHistoryView();
            borderPane.requestFocus();
        });

        balanceLabel.setId("balanceLabel");
        balanceLabel.setText("Balance: " + user.getBalance());
        balanceLabel.setMinWidth(250);
        balanceLabel.setFont(new Font(20));
        balanceLabel.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        HBox controls = new HBox(20, balanceLabel, addButton, buyButton, sellButton, ROIButton, historyButton);
        controls.setPadding(new Insets(20, 20, 20, 20));
        controls.setAlignment(Pos.CENTER);

        borderPane.setTop(controls);

        Scene scene = new Scene(borderPane, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }

    private void createAddView() {AddView addView = new AddView(user, balanceLabel);}
    private void createBuyView(){
        BuyView buyView = new BuyView(user, balanceLabel);
    }

    private void createSellView(){
        SellView sellView = new SellView(user, balanceLabel);
    }

    private void createROIView() {ROIView roiView = new ROIView(user);}

    private void createHistoryView() {HistoryView historyView = new HistoryView(user);}
}
