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

public class StockView {

    Stage stage;

    BorderPane borderPane;
    Canvas canvas;
    GraphicsContext gc; //the graphics context will be linked to the canvas

    //Will start on the login page
    public StockView(Stage stage) {
        this.stage = stage;
        initUI();
    }

    private void initUI(){
        this.stage.setTitle("Stock the Past");
        borderPane = new BorderPane();
        borderPane.setStyle("-fx-background-color: #121212;");

        canvas = new Canvas(500, 500);
        canvas.setId("Canvas");
        gc = canvas.getGraphicsContext2D();

        Scene scene = new Scene(borderPane, 500, 500);
        this.stage.setScene(scene);
        this.stage.show();
    }
}
