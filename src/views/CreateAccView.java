package views;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CreateAccView{

    StockView stockView;

    private int buttonLength = 150;
    private int buttonWidth = 50;

    public final int fontSizeDefault = 20;

    //Create Account button
    private Button createButton = new Button("Create");
    //TextField for username and password
    private TextField newusernameField = new TextField("");
    private PasswordField newpasswordField = new PasswordField();
    private PasswordField confirmpasswordField = new PasswordField();
    //Error Label
    private Label createAccountError = new Label("");
    //Title
    private Label title = new Label(String.format("Welcome to Stock The Past"));

    //constructor
    public CreateAccView(StockView StockView){
        this.stockView = StockView;
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(stockView.stage);
        //container for the information
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        //initialization for buttons and labels
        createAccountError.setId("createAccountError");
        title.setId("title");
        newpasswordField.setId("newpasswordField");
        newpasswordField.setPromptText("New Password");
        newusernameField.setId("newusernameField");
        newusernameField.setPromptText("New Username");
        confirmpasswordField.setId("confirmpasswordField");
        confirmpasswordField.setPromptText("Confirm Password");

        //combination
        VBox createAccountBox = new VBox(10, title, newusernameField, newpasswordField, confirmpasswordField, createAccountError);

    }
}
