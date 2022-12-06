package views;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.geometry.Insets;

//public class AccessibilityPage extends Application implements EventHandler<ActionEvent> {
public class AccessibilityView {

    Button bigButton, defaultBbutton, smallButton;

    public final double fontSizeSmall = 8;
    public final double fontSizeDefault = 16;
    public final double fontSizeBig = 32;

    private int buttonLength = 150;
    private int buttonWidth = 50;




    public AccessibilityView() {
        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");


        //creating the button
        defaultBbutton = new Button("Default");
        defaultBbutton.setId("Default");
        defaultBbutton.setPrefSize(buttonLength, buttonWidth);
        defaultBbutton.setFont(new Font(fontSizeDefault));
        defaultBbutton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        bigButton = new Button("Big");
        bigButton.setId("Big");
        bigButton.setPrefSize(buttonLength, buttonWidth);
        bigButton.setFont(new Font(fontSizeBig));
        bigButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        smallButton = new Button("Small");
        smallButton.setId("Small");
        smallButton.setPrefSize(buttonLength, buttonWidth);
        smallButton.setFont(new Font(fontSizeSmall));
        smallButton.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");

        //top right bottom left
        VBox accessibilityBox = new VBox(75, bigButton, defaultBbutton, smallButton);
//        HBox topButton = new HBox(bigButton);
//        topButton.setPadding(new Insets((borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2, (borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2));
//        topButton.setAlignment(Pos.CENTER);
//
//        HBox centerButton = new HBox(defaultBbutton);
//        centerButton.setPadding(new Insets((borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2, (borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2));
//        centerButton.setAlignment(Pos.CENTER);
//
//        HBox bottomBbuttons = new HBox(smallButton);
//        bottomBbuttons.setPadding(new Insets((borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2, (borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2));
//        bottomBbuttons.setAlignment(Pos.CENTER);

//        borderPane.setTop(topButton);
//        borderPane.setCenter(centerButton);
//        borderPane.setBottom(bottomBbuttons);

        //setting the size for our window
        accessibilityBox.setAlignment(Pos.CENTER);

        dialogVbox.getChildren().add(accessibilityBox);
        Scene dialogScene = new Scene(dialogVbox, 400, 400);
        dialog.setScene(dialogScene);
        dialog.show();

        defaultBbutton.setOnAction(e -> {
            AddView.setFontSize(fontSizeDefault);
            BuyView.setFontSize(fontSizeDefault);
            HistoryView.setFontSize(fontSizeDefault);
            ROIView.setFontSize(fontSizeDefault);
            SellView.setFontSize(fontSizeDefault);
            StockView.setFontSize(fontSizeDefault);

        });

        bigButton.setOnAction(e -> {
            AddView.setFontSize(fontSizeBig);
            BuyView.setFontSize(fontSizeBig);
            HistoryView.setFontSize(fontSizeBig);
            ROIView.setFontSize(fontSizeBig);
            SellView.setFontSize(fontSizeBig);
            StockView.setFontSize(fontSizeBig);
        });

        smallButton.setOnAction(e -> {
            AddView.setFontSize(fontSizeSmall);
            BuyView.setFontSize(fontSizeSmall);
            HistoryView.setFontSize(fontSizeSmall);
            ROIView.setFontSize(fontSizeSmall);
            SellView.setFontSize(fontSizeSmall);
            StockView.setFontSize(fontSizeSmall);
        });
    }
}
