package views;

import Iterator.ReadFile;
import Stocks.*;
import javafx.scene.Group;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import User.User;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

public class UserView {

    private User user;

    private TextField addBalanceTextField = new TextField("");

    public ReadFile date;

    StockFactory stockFactory = new StockFactory();
    Button addButton, buyButton, sellButton, ROIButton, historyButton, nextButton, logoutButton, accessibilityButton;

    Label balanceLabel = new Label();

    Label dateLabel = new Label();
    BorderPane borderPane;

    Stage stage;

    XYChart.Series<String, Number> graphAmazon = new XYChart.Series<>();

    XYChart.Series<String, Number> graphApple = new XYChart.Series<>();

    XYChart.Series<String, Number> graphMeta = new XYChart.Series<>();

    XYChart.Series<String, Number> graphMicrosoft = new XYChart.Series<>();

    XYChart.Series<String, Number> graphStarBucks = new XYChart.Series<>();

    XYChart.Series<String, Number> graphTesla = new XYChart.Series<>();

    public UserView(User user, Stage primaryStage) {
        this.user = user;
        this.stage = primaryStage;
        initUI();
    }

    public void initUI() {
        stage.setTitle("CSC207 StockThePast");
        borderPane = new BorderPane();

        date = new ReadFile("./Stocks Data/Amazon.csv");

        addButton = new Button("Add\nBalance");
        addButton.setId("AddBalance");
        addButton.setPrefSize(80, 50);
        addButton.setFont(new Font(14));
        addButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        addButton.setOnAction(e -> {
            createAddView();
            borderPane.requestFocus();
        });

        buyButton = new Button("Buy");
        buyButton.setId("Buy");
        buyButton.setPrefSize(80, 50);
        buyButton.setFont(new Font(14));
        buyButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        buyButton.setOnAction(e -> {
            createBuyView();
            borderPane.requestFocus();
        });

        sellButton = new Button("Sell");
        sellButton.setId("Sell");
        sellButton.setPrefSize(80, 50);
        sellButton.setFont(new Font(14));
        sellButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        sellButton.setOnAction(e -> {
            createSellView();
            borderPane.requestFocus();
        });

        ROIButton = new Button("ROI");
        ROIButton.setId("ROI");
        ROIButton.setPrefSize(80, 50);
        ROIButton.setFont(new Font(14));
        ROIButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        ROIButton.setOnAction(e -> {
            createROIView();
            borderPane.requestFocus();
        });

        historyButton = new Button("History");
        historyButton.setId("History");
        historyButton.setPrefSize(80, 50);
        historyButton.setFont(new Font(14));
        historyButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        historyButton.setOnAction(e -> {
            createHistoryView();
            borderPane.requestFocus();
        });

        nextButton = new Button("Next Day");
        nextButton.setId("nextDay");
        nextButton.setPrefSize(80, 50);
        nextButton.setFont(new Font(14));
        nextButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        nextButton.setOnAction(e -> {
            date.getNextDay();
            dateLabel.setText("Date: " + date.getCurrDay());
            nextDay();
            borderPane.requestFocus();
        });

        balanceLabel.setId("balanceLabel");
        balanceLabel.setText("Balance: " + user.getBalance());
        balanceLabel.setMinWidth(200);
        balanceLabel.setFont(new Font(14));
        balanceLabel.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        dateLabel.setId("dateLabel");
        dateLabel.setText("Date: " + date.getCurrDay());
        dateLabel.setMinWidth(125);
        dateLabel.setFont(new Font(14));
        dateLabel.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        logoutButton = new Button("Logout");
        logoutButton.setId("logoutButton");
        logoutButton.setPrefSize(100, 50);
        logoutButton.setFont(new Font(12));
        logoutButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        logoutButton.setOnAction(e -> {
            StockView.logout();
            borderPane.requestFocus();
        });

        accessibilityButton = new Button("Accessibility");
        accessibilityButton.setId("accessibility");
        accessibilityButton.setPrefSize(100, 50);
        accessibilityButton.setFont(new Font(12));
        accessibilityButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        accessibilityButton.setOnAction(e -> {
            createAccessibilityView();
            borderPane.requestFocus();
        });

        HBox logButton = new HBox(800, accessibilityButton, logoutButton);
        logButton.setAlignment(Pos.CENTER);

        HBox controls = new HBox(20, dateLabel, balanceLabel, nextButton, addButton, buyButton, sellButton, ROIButton, historyButton);
        controls.setPadding(new Insets(20, 20, 20, 20));
        controls.setAlignment(Pos.CENTER);

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
        borderPane.setBottom(logButton);

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
            String day = date.getCurrDay();
            graphAmazon.getData().add(new XYChart.Data<String, Number>(day, stockFactory.getStock("Amazon").getPrice(day)));
            graphApple.getData().add(new XYChart.Data<String, Number>(day, stockFactory.getStock("Apple").getPrice(day)));
            graphMeta.getData().add(new XYChart.Data<String, Number>(day, stockFactory.getStock("Meta").getPrice(day)));
            graphMicrosoft.getData().add(new XYChart.Data<String, Number>(day, stockFactory.getStock("Microsoft").getPrice(day)));
            graphStarBucks.getData().add(new XYChart.Data<String, Number>(day, stockFactory.getStock("StarBucks").getPrice(day)));
            graphTesla.getData().add(new XYChart.Data<String, Number>(day, stockFactory.getStock("Tesla").getPrice(day)));
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
}
