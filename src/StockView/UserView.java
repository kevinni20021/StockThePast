package StockView;

import Iterator.ReadFile;
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

import java.util.HashMap;

public class UserView {

    private User user;

    private TextField addBalanceTextField = new TextField("");

    public ReadFile date;

    Button addButton, buyButton, sellButton, ROIButton, historyButton, nextButton;

    Label balanceLabel = new Label();

    Label dateLabel = new Label();
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

        nextButton.setOnAction(e -> {
            date.getNextDay();
            dateLabel.setText("Date: " + date.getCurrDay());
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

        Group root = new Group();

        CategoryAxis x = new CategoryAxis();
        x.setLabel("Days");

        NumberAxis y = new NumberAxis();
        y.setLabel("Price");

        LineChart<String, Number> line = new LineChart<String, Number>(x, y);
        XYChart.Series<String, Number> Amazon = new XYChart.Series<>();
        XYChart.Series<String, Number> Apple = new XYChart.Series<>();
        XYChart.Series<String, Number> Meta = new XYChart.Series<>();
        XYChart.Series<String, Number> Microsoft = new XYChart.Series<>();
        XYChart.Series<String, Number> StarBucks = new XYChart.Series<>();
        XYChart.Series<String, Number> Tesla = new XYChart.Series<>();


//        try {
//            HashMap<String, HashMap<String, Double>> hack = user.stockDate(user);
//            for (String key : hack.keySet()) {
//                HashMap<String, Double> easy = new HashMap<String, Double>(hack.get(key));
//                for (String keys : easy.keySet()) {
//                    stock.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
//                }
//            }
//
//            line.getData().add(stock);
//            root.getChildren().add(line);
//            stage.setScene(scene);
//            stage.show();
////
////        }
//        } catch (Exception e) {
//            System.out.print("No such User.User\n");
//        }

        //Testing Purposes
        HashMap<String, HashMap<String, Double>> hack = new HashMap<String, HashMap<String, Double>>();
        hack.put("Stocks.Apple", new HashMap<String, Double>());
        hack.get("Stocks.Apple").put("10/12/2022", 120.0);
        hack.get("Stocks.Apple").put("10/13/2022", 120.0);
        hack.put("Stocks.Meta", new HashMap<String, Double>());
        hack.get("Stocks.Meta").put("11/12/2022", 1220.0);
        hack.get("Stocks.Meta").put("11/13/2022", 15000.0);
        for (String key : hack.keySet()) {
            HashMap<String, Double> easy = new HashMap<String, Double>(hack.get(key));
            for (String keys : easy.keySet()) {
                if (key.equals("Stocks.Amazon")) {
                    Amazon.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("Stocks.Apple")) {
                    Apple.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));

                }
                if (key.equals("Stocks.Meta")) {
                    Meta.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("Stocks.Microsoft")) {
                    Microsoft.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("Stocks.StarBucks")) {
                    StarBucks.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("Stocks.Tesla")) {
                    Tesla.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
            }

//        stock.getData().add(new XYChart.Data<String, Number>("10/05/2003", 120.00));
//        stock.getData().add(new XYChart.Data<String, Number>("10/05/2004", 190.00));

        }
        line.getData().addAll(Amazon, Apple, Meta, Microsoft, StarBucks, Tesla);
        root.getChildren().add(line);

        borderPane.setTop(controls);
        borderPane.setCenter(root);

        Scene scene = new Scene(borderPane, 1000, 800);
        stage.setScene(scene);
        stage.show();
    }

    private void createAddView() {AddView addView = new AddView(user, balanceLabel);}

    private void createBuyView(){ BuyView buyView = new BuyView(user, balanceLabel, date.getCurrDay()); }

    private void createSellView(){
        SellView sellView = new SellView(user, balanceLabel, date.getCurrDay());
    }

    private void createROIView() {ROIView roiView = new ROIView(user, date.getCurrDay());}

    private void createHistoryView() {HistoryView historyView = new HistoryView(user);}
}
