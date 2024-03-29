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


/**
 * This class is responsible for the history view subpage of the application
 */
public class HistoryView {
    private Label historyLabel = new Label(String.format("Stock History"));
    private ListView<String> stocksList;
    public static double fontSize = 16;


    /**
     * Main code for the page
     * @param user the specific user that the program is checking its history on
     */
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
        historyLabel.setFont(new Font(fontSize));

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
        HistoryView.fontSize = size;
    }
}
