package Drawing;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class StocksView {
    Stage stage;
    BorderPane borderPane;
    Canvas canvas;
    GraphicsContext gc;

    double width;
    double height;

    public StocksView(StocksModel model, Stage stage) {
        this.stage = stage;
        initUI();
    }

    private void initUI() {
        this.width = 400;
        this.height = 400;

        canvas = new Canvas(this.width, this.height);
        canvas.setId("Canvas");
        gc = canvas.getGraphicsContext2D();

        var scene = new Scene(borderPane, 800, 800);
        this.stage.setScene(scene);
        this.stage.show();
    }

    private void paint() {
        gc.setStroke(Color.GREEN);
        gc.setFill(Color.BLACK);
    }

}
