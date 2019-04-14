package gui.controller;

import client.Client;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.net.URL;
import java.util.Date;
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
        for (int i = 1; i <= 52; i++) {
            weeklyseries.getData().add(new XYChart.Data(Integer.toString(i),
                    Client.getWeekCo2(Client.getUrl(), Client.getUser(),
                            Client.getRestTemplate(), i)));
        }
        weekly.getData().addAll(weeklyseries);

        @SuppressWarnings("unused")
        XYChart.Series monthlyseries = new XYChart.Series<>();
        for (int i = 3; i >= 0; i--) {
            monthlyseries.getData().add(new XYChart.Data(Integer
                    .toString(new Date().getMonth() - i + 1),
                    Client.getMonthCo2(Client.getUrl(), Client.getUser(),
                            Client.getRestTemplate(), "0"
                                    + Integer.toString(new Date().getMonth() - i + 1))));
        }
        monthly.getData().add(monthlyseries);
    }

}
