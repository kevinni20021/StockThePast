package views;


import Command.Command;
import Command.buyCommand;
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


/**
 * This class is responsible for the buy stock subpage of the application
 */
public class BuyView {
    private Label selectStockLabel;
    private Button selectStockButton;
    private ListView<String> stocksList;

    private StockFactory stockFactory = new StockFactory();
    private Label amountLabel = new Label(String.format("Enter the amount of\nstocks you want to buy"));
    private TextField amount = new TextField("");

    private Label buyLabel = new Label("");
    public static double fontSize = 16;


    /**
     * Main code that created this page
     * @param user the user the program is buying stocks for
     * @param balanceLabel the label the program is changing
     * @param date the date the user is buying the stocks at
     */
    public BuyView(User user, Label balanceLabel, String date) {
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

        try {
            stocksList.getItems().add("Amazon" + " = " + stockFactory.getStock("Amazon").getPrice(date));
            stocksList.getItems().add("Apple" + " = " + stockFactory.getStock("Apple").getPrice(date));
            stocksList.getItems().add("Meta" + " = " + stockFactory.getStock("Meta").getPrice(date));
            stocksList.getItems().add("Microsoft" + " = " + stockFactory.getStock("Microsoft").getPrice(date));
            stocksList.getItems().add("StarBucks" + " = " + stockFactory.getStock("StarBucks").getPrice(date));
            stocksList.getItems().add("Tesla" + " = " + stockFactory.getStock("Tesla").getPrice(date));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        selectStockButton = new Button("Select stock");
        selectStockButton.setId("selectStock"); // DO NOT MODIFY ID

        //on selection, do somethine
        selectStockButton.setOnAction(e -> {
            try {
                int index = stocksList.getSelectionModel().getSelectedItem().indexOf(" ");
                String name = stocksList.getSelectionModel().getSelectedItem().substring(0, index);
                StocksData stock = stockFactory.getStock(name);
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
        amountLabel.setFont(new Font(fontSize));

        amount.setId("amount");
        amount.setStyle("-fx-text-fill: #17871b;");
        amount.setFont(new Font(fontSize));

        selectStockLabel.setStyle("-fx-text-fill: #e8e6e3");
        selectStockLabel.setFont(new Font(fontSize));

        buyLabel.setStyle("-fx-text-fill: #e8e6e3;");
        buyLabel.setFont(new Font(fontSize));

        selectStockButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        if (fontSize > 16) {
            selectStockButton.setPrefSize(300, 50);
        } else {
            selectStockButton.setPrefSize(200, 50);
        }
        selectStockButton.setFont(new Font(fontSize));

        selectBoardBox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(selectBoardBox);
        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();
    }


    /**
     * This is a setter method for setting the fontSize
     */
    public static void setFontSize(double size) {
        BuyView.fontSize = size;
    }
}
