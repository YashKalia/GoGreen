package gui.controller;

import client.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
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
    @FXML
    private Button Home;
    @FXML
    private AnchorPane Rootpane;

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
    @FXML
    void clickhome(ActionEvent event) throws Exception {
        Parent secondview;
        @SuppressWarnings("deprecation")
		URL url = new File("src/main/java/gui/fxml/Homepage.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) Rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

}
