package views;

import Stocks.StocksData;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import User.User;


public class HistoryView {
    private Label historyLabel = new Label(String.format("Stock History"));
    private ListView<String> stocksList;

    public HistoryView(User user) {
        stocksList = new ListView<>();

        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        stocksList.setId("stocksList");  // DO NOT MODIFY ID
        stocksList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        for (StocksData stock : user.stocksOwned.keySet()) {
            for (ArrayList<Object> stockData : user.stocksOwned.get(stock)) {
                stocksList.getItems().add(stock.getName() + " " + stockData.toString());
            }
        }

        VBox selectBoardBox = new VBox(10, historyLabel, stocksList);

        // Default styles which can be modified
        stocksList.setPrefHeight(100);

        historyLabel.setId("historyLabel");
        historyLabel.setStyle("-fx-text-fill: #e8e6e3;");
        historyLabel.setFont(new Font(16));

        selectBoardBox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(selectBoardBox);
        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
