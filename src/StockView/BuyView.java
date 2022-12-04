package src.StockView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import src.*;
import src.Command.Command;
import src.Command.buyCommand;

import java.io.IOException;


public class BuyView {
    private Label selectStockLabel;
    private Button selectStockButton;
    private ListView<String> stocksList;
    private Label amountLabel = new Label(String.format("Enter the amount of stocks you want to buy"));
    private TextField amount = new TextField("");

    private Label buyLabel = new Label("");

    public BuyView(User user, Label balanceLabel) {
        String date = "11/11/2022";
        Command buy = new buyCommand(user);
        selectStockLabel = new Label(String.format("List of stocks to buy"));
        stocksList = new ListView<>();

        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        selectStockLabel.setId("stockLabel"); // DO NOT MODIFY ID

        stocksList.setId("stocksList");  // DO NOT MODIFY ID
        stocksList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        stocksList.getItems().add("Amazon");
        stocksList.getItems().add("Apple");
        stocksList.getItems().add("Meta");
        stocksList.getItems().add("Microsoft");
        stocksList.getItems().add("StarBucks");
        stocksList.getItems().add("Tesla");

        selectStockButton = new Button("Select stock");
        selectStockButton.setId("selectStock"); // DO NOT MODIFY ID

        //on selection, do somethine
        selectStockButton.setOnAction(e -> {
            try {
                StocksData stock = getStock(stocksList.getSelectionModel().getSelectedItem());
                buy.execute(stock, Double.parseDouble(amount.getText()), date);
                if (user.getStatus()) {
                    buyLabel.setText("Stocks Successfully Bought!");
                    balanceLabel.setText("Balance: " + user.getBalance());
                }
                else {
                    buyLabel.setText("Could Not Buy Stocks");
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        VBox selectBoardBox = new VBox(10, amountLabel, amount, selectStockLabel, stocksList, selectStockButton, buyLabel);

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

        buyLabel.setStyle("-fx-text-fill: #e8e6e3;");
        buyLabel.setFont(new Font(16));

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
            case "Starbucks" -> new StarBucks();
            case "Tesla" -> new Tesla();
            default -> null;
        };
    }
}
