package StockView;


import Command.Command;
import Command.sellCommand;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import Stocks.*;

import java.io.IOException;
import User.User;
import java.util.ArrayList;


public class SellView {
    private Label selectStockLabel;
    private Button selectStockButton;
    private ListView<String> stocksList;
    private Label amountLabel = new Label(String.format("Enter the amount of stocks you want to sell"));
    private TextField amount = new TextField("");

    private Label sellLabel = new Label("");

    public SellView(User user, Label balanceLabel, String date) {
        Command sell = new sellCommand(user);
        selectStockLabel = new Label(String.format("List of stocks to sell"));
        stocksList = new ListView<>();

        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        selectStockLabel.setId("stockLabel"); // DO NOT MODIFY ID

        stocksList.setId("stocksList");  // DO NOT MODIFY ID
        stocksList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        for (StocksData stock : user.stocksOwned.keySet()) {
            System.out.println(user.stocksOwned.keySet());
            double owned = user.amountOwned(stock);
            if (owned > 0) {
                stocksList.getItems().add(stock.getName() + " = " + stock.getPrice(date) + ", Owned: " + owned);
            }
        }

        selectStockButton = new Button("Select stock");
        selectStockButton.setId("selectStock"); // DO NOT MODIFY ID

        //on selection, do somethine
        selectStockButton.setOnAction(e -> {
            try {
                int index = stocksList.getSelectionModel().getSelectedItem().indexOf(" ");
                String name = stocksList.getSelectionModel().getSelectedItem().substring(0, index);
                StocksData stock = getStock(name);
                sell.execute(stock, Double.parseDouble(amount.getText()), date);
                if (user.getStatus()) {
                    sellLabel.setText("Stocks Successfully Sold!");
                    balanceLabel.setText("Balance: " + user.getBalance());
                }
                else {
                    sellLabel.setText("Could Not Sell Stocks");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox selectBoardBox = new VBox(10, amountLabel, amount, selectStockLabel, stocksList, selectStockButton, sellLabel);

        // Default styles which can be modified
        stocksList.setPrefHeight(100);

        amountLabel.setId("amountLabel");
        amountLabel.setStyle("-fx-text-fill: #e8e6e3;");
        amountLabel.setFont(new Font(16));

        amount.setId("amount");
        amount.setStyle("-fx-text-fill: #e8e6e3;");
        amount.setFont(new Font(16));

        selectStockLabel.setStyle("-fx-text-fill: #e8e6e3");
        selectStockLabel.setFont(new Font(16));

        sellLabel.setStyle("-fx-text-fill: #e8e6e3;");
        sellLabel.setFont(new Font(16));

        selectStockButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        selectStockButton.setPrefSize(200, 50);
        selectStockButton.setFont(new Font(16));

        selectBoardBox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(selectBoardBox);
        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public StocksData getStock(String name) throws IOException {
        return switch (name) {
            case "Amazon" -> new Amazon();
            case "Apple" -> new Apple();
            case "Meta" -> new Meta();
            case "Microsoft" -> new Microsoft();
            case "StarBucks" -> new StarBucks();
            case "Tesla" -> new Tesla();
            default -> null;
        };
    }
}
