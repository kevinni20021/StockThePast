//package views;
//
//import User.User;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.layout.VBox;
//import javafx.scene.text.Font;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//
//public class AddView {
//    private Button add;
//    private Label amountLabel = new Label(String.format("Enter the balance you want to add"));
//    private TextField amount = new TextField("");
//
//    private Label resultLabel = new Label("");
//
//    public AddView(User user, Label balanceLabel) {
//
//        final Stage dialog = new Stage(); //dialogue box
//        dialog.initModality(Modality.APPLICATION_MODAL);
//        VBox dialogVbox = new VBox(20);
//        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
//        dialogVbox.setStyle("-fx-background-color: #121212;");
//
//        add = new Button("Add Balance");
//        add.setId("selectStock"); // DO NOT MODIFY ID
//
//        //on selection, do somethine
//        add.setOnAction(e -> {
//            try {
//                user.addBalance(Double.parseDouble(amount.getText()));
//                balanceLabel.setText("Balance: " + user.getBalance());
//                resultLabel.setText("Balanced added!");
//            }
//            catch (Exception exception) {
//                resultLabel.setText("Invalid input");
//            }
//        });
//
//        VBox selectBoardBox = new VBox(10, amountLabel, amount, add, resultLabel);
//
//        // Default styles which can be modified
//
//        amountLabel.setId("amountLabel");
//        amountLabel.setStyle("-fx-text-fill: #e8e6e3;");
//        amountLabel.setFont(new Font(16));
//
//        amount.setId("amount");
//        amount.setStyle("-fx-text-fill: #e8e6e3;");
//        amount.setFont(new Font(16));
//
//        add.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
//        add.setPrefSize(200, 50);
//        add.setFont(new Font(16));
//
//        resultLabel.setStyle("-fx-text-fill: #e8e6e3;");
//        resultLabel.setFont(new Font(16));
//
//        selectBoardBox.setAlignment(Pos.CENTER);
//
//        dialogVbox.getChildren().add(selectBoardBox);
//        Scene dialogScene = new Scene(dialogVbox, 400, 400);
//        dialog.setScene(dialogScene);
//        dialog.show();
//    }
//}


package views;

import User.User;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 * This class is responsible for the add balance subpage of the application
 */
public class AddView {
    private Button add;
    private Label amountLabel = new Label(String.format("Enter the balance you want to add"));
    private TextField amount = new TextField("");

    private Label resultLabel = new Label("");
    public static double fontSize = 16;


    /**
     * Main code that created the page
     * @param user the specific user that the program is adding balance to
     * @param balanceLabel the label that the program is editing
     */
    public AddView(User user, Label balanceLabel) {

        final Stage dialog = new Stage(); //dialogue box
        dialog.initModality(Modality.APPLICATION_MODAL);
        VBox dialogVbox = new VBox(20);
        dialogVbox.setPadding(new Insets(20, 20, 20, 20));
        dialogVbox.setStyle("-fx-background-color: #121212;");

        add = new Button("Add Balance");
        add.setId("selectStock"); // DO NOT MODIFY ID

        //on selection, do somethine
        add.setOnAction(e -> {
            try {
                user.addBalance(Double.parseDouble(amount.getText()));
                balanceLabel.setText("Balance: " + user.getBalance());
                resultLabel.setText("Balanced added!");
            }
            catch (Exception exception) {
                resultLabel.setText("Invalid input");
            }
        });

        VBox selectBoardBox = new VBox(10, amountLabel, amount, add, resultLabel);

        // Default styles which can be modified

        amountLabel.setId("amountLabel");
        amountLabel.setStyle("-fx-text-fill: #e8e6e3;");
        amountLabel.setFont(new Font(fontSize));

        amount.setId("amount");
        amount.setStyle("-fx-text-fill: #17871b;");
        amount.setFont(new Font(fontSize));

        add.setStyle("-fx-background-color: #17871b; -fx-text-fill: white;");
        if (fontSize > 16) {
            add.setPrefSize(300, 50);
        } else {
            add.setPrefSize(200, 50);
        }

        add.setFont(new Font(fontSize));

        resultLabel.setStyle("-fx-text-fill: #e8e6e3;");
        resultLabel.setFont(new Font(fontSize));

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
        AddView.fontSize = size;
    }
}

