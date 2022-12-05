package Drawing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import src.User;

import java.util.HashMap;

public class StocksViewer extends Application {
    private User user;

    public static void main(String[] args) {
        launch(args);
    }

    public void getUser(User user) {
        this.user = user;
    }

    public void start(Stage stage) {

        Group root = new Group();
        Scene scene = new Scene(root, 800, 800);
        stage.setWidth(800);
        stage.setHeight(800);

        CategoryAxis x = new CategoryAxis();
        x.setLabel("Days");

        NumberAxis y = new NumberAxis();
        y.setLabel("Gain");

        LineChart<String, Number> line = new LineChart<String, Number>(x, y);
        XYChart.Series<String, Number> stock = new XYChart.Series<>();
        XYChart.Series<String, Number> stock1 = new XYChart.Series<>();
        XYChart.Series<String, Number> stock2 = new XYChart.Series<>();
        XYChart.Series<String, Number> stock3 = new XYChart.Series<>();
        XYChart.Series<String, Number> stock4 = new XYChart.Series<>();
        XYChart.Series<String, Number> stock5 = new XYChart.Series<>();


        try {
            HashMap<String, HashMap<String, Double>> hack = user.stockDate(user);
            for (String key : hack.keySet()) {
                HashMap<String, Double> easy = new HashMap<String, Double>(hack.get(key));
                for (String keys : easy.keySet()) {
                    stock.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
            }

            line.getData().add(stock);
            root.getChildren().add(line);
            stage.setScene(scene);
            stage.show();
//
//        }
        } catch (Exception e) {
            System.out.print("No such User\n");
        }

        //Testing Purposes
        HashMap<String, HashMap<String, Double>> hack = new HashMap<String, HashMap<String, Double>>();
        hack.put("Apple", new HashMap<String, Double>());
        hack.get("Apple").put("10/12/2022", 120.0);
        hack.get("Apple").put("10/13/2022", 120.0);
        hack.put("Meta", new HashMap<String, Double>());
        hack.get("Meta").put("11/12/2022", 1220.0);
        hack.get("Meta").put("11/13/2022", 1000.0);
        for (String key : hack.keySet()) {
            HashMap<String, Double> easy = new HashMap<String, Double>(hack.get(key));
            for (String keys : easy.keySet()) {

                if (key.equals("Amazon")) {
                    stock.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("Apple")) {
                    stock1.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));

                }
                if (key.equals("Meta")) {
                    stock2.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("Microsoft")) {
                    stock3.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("StarBucks")) {
                    stock4.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
                if (key.equals("Tesla")) {
                    stock5.getData().add(new XYChart.Data<String, Number>(keys, easy.get(keys)));
                }
            }

//        stock.getData().add(new XYChart.Data<String, Number>("10/05/2003", 120.00));
//        stock.getData().add(new XYChart.Data<String, Number>("10/05/2004", 190.00));

        }
        line.getData().addAll(stock, stock1, stock2, stock3, stock4, stock5);
        root.getChildren().add(line);
        stage.setScene(scene);
        stage.show();
    }
}
