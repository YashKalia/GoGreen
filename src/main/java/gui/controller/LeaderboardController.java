package application;

import client.Client;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;



public class LeaderboardController implements Initializable {

    @FXML
    private AnchorPane rootpane;
    @FXML
    private CategoryAxis x1;
    @FXML
    private NumberAxis y1;
    @FXML
    private BarChart leaderboard;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override

    public void initialize(URL location, ResourceBundle resources) {

        XYChart.Series weeklyseries = new XYChart.Series<>();

        HashSet<String> friends = new HashSet<>();

        friends = Client.getMutualFriends(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate());
        LinkedHashMap<String, Double> scores = new LinkedHashMap<>();

        for (String friend : friends) {
            scores.put(friend, Client.getTotalCo2(Client.getUrl(),
                    new User(friend, null), Client.getRestTemplate()));

            weeklyseries.getData().add(new XYChart.Data(friend, Client.getTotalCo2(Client.getUrl(),
                    new User(friend, null), Client.getRestTemplate())));
        }

        weeklyseries.getData().add(new XYChart.Data(Client.getUser().getUsername(),
                Client.getTotalCo2(Client.getUrl(), Client.getUser(), Client.getRestTemplate())));

        leaderboard.getData().addAll(weeklyseries);

    }

    @FXML
    void clickhome(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Homepage.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }


}
