package Accessibility;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.rmi.server.ObjID;
import java.util.*;

//public class AccessibilityPage extends Application implements EventHandler<ActionEvent> {
public class AccessibilityPage{

    Button bigButton, defaultBbutton, smallButton;

    Stage stage;
    BorderPane borderPane;
    public final int fontSizeSmall = 10;
    public final int fontSizeDefault = 20;
    public final int fontSizeBig = 40;

    private int borderPaneLength = 1000;
    private int borderPaneWidth = 500;
    private int buttonLength = 150;
    private int buttonWidth = 50;


    public AccessibilityPage(Stage stage) {
        this.stage = stage;
        initUI();
    }
    public void initUI() {
        borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #121212;");

        //naming the window
        this.stage.setTitle("Accessibility");

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
        HBox topButton = new HBox(bigButton);
        topButton.setPadding(new Insets((borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2, (borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2));
        topButton.setAlignment(Pos.CENTER);

        HBox centerButton = new HBox(defaultBbutton);
        centerButton.setPadding(new Insets((borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2, (borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2));
        centerButton.setAlignment(Pos.CENTER);

        HBox bottomBbuttons = new HBox(smallButton);
        bottomBbuttons.setPadding(new Insets((borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2, (borderPaneWidth - 3 * buttonWidth) / 6, (borderPaneLength -  buttonLength) / 2));
        bottomBbuttons.setAlignment(Pos.CENTER);

        borderPane.setTop(topButton);
        borderPane.setCenter(centerButton);
        borderPane.setBottom(bottomBbuttons);

        //setting the size for our window
        Scene scene = new Scene(borderPane, borderPaneLength, borderPaneWidth);
        this.stage.setScene(scene);
        this.stage.show();

        defaultBbutton.setOnAction(e -> {
            System.out.println("Default");
            borderPane.requestFocus();
        });

        bigButton.setOnAction(e -> {
            System.out.println("Bigger");
            borderPane.requestFocus();
        });

        smallButton.setOnAction(e -> {
            System.out.println("Smaller");
            borderPane.requestFocus();
        });


    }
}
