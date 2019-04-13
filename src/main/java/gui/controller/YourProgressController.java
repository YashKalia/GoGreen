package gui.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.ResourceBundle;


public class YourProgressController implements Initializable {

    @FXML
    private CategoryAxis x1;
    @FXML
    private CategoryAxis x2;
    @FXML
    private NumberAxis y1;
    @FXML
    private NumberAxis y2;
    @FXML
    private LineChart<?, ?> weekly;
    @FXML
    private LineChart<?, ?> monthly;

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        XYChart.Series weeklyseries = new XYChart.Series<>();

        weeklyseries.getData().add(new XYChart.Data("1", 23));
        // Replace the number "23" with the server
        // method to find CO2 consumption for that particular week.
        weeklyseries.getData().add(new XYChart.Data("2", 10));
        weeklyseries.getData().add(new XYChart.Data("3", 12));
        weeklyseries.getData().add(new XYChart.Data("4", 2));
        weekly.getData().addAll(weeklyseries);

        @SuppressWarnings("unused")
        XYChart.Series monthlyseries = new XYChart.Series<>();
    }

}
