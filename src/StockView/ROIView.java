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


public class ROIView {
    private Label returnLabel = new Label(String.format("Return on Investments"));

    private Label netWorth = new Label();
    private ListView<String> stocksList;

    public ROIView(User user) {
        String date = "11/18/2022";
        stocksList = new ListView<>();

        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        stocksList.setId("stocksList");  // DO NOT MODIFY ID
        stocksList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        for (String stock : user.getROI(date)) {
            stocksList.getItems().add(stock);
        }

        VBox selectBoardBox = new VBox(10, returnLabel, netWorth, stocksList);

        stocksList.setPrefHeight(100);

        returnLabel.setId("amountLabel");
        returnLabel.setStyle("-fx-text-fill: #e8e6e3;");
        returnLabel.setFont(new Font(16));

        netWorth.setText("Net worth: " + user.getNW(date));
        netWorth.setId("amountLabel");
        netWorth.setStyle("-fx-text-fill: #e8e6e3;");
        netWorth.setFont(new Font(16));

        selectBoardBox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(selectBoardBox);
        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
