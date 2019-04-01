package application;

import java.net.URL;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

import client.Client;
import entity.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class LeaderboardController implements Initializable {

    @FXML
    private CategoryAxis x1;
    @FXML
    private NumberAxis y1;
    @FXML
    private BarChart Leaderboard;

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Override

    public void initialize(URL location, ResourceBundle resources) {

        XYChart.Series weeklyseries = new XYChart.Series<>();

        HashSet<String> friends = new HashSet<>();

        friends = Client.getMutualFriends(Client.getUrl(), Client.getUser(), Client.getRestTemplate());
        LinkedHashMap<String, Double> scores = new LinkedHashMap<>();

        for (String friend : friends) {
            scores.put(friend, Client.getTotalCo2(Client.getUrl(), new User(friend, null), Client.getRestTemplate()));
            weeklyseries.getData().add(new XYChart.Data(friend, Client.getTotalCo2(Client.getUrl(), new User(friend, null), Client.getRestTemplate())));
        }

        weeklyseries.getData().add(new XYChart.Data(Client.getUser().getUsername(), Client.getTotalCo2(Client.getUrl(), Client.getUser(), Client.getRestTemplate())));

//        weeklyseries.getData().add(new XYChart.Data("1", 23)); // Replace the number "23" with the server method to find CO2 consumption for that particular week and please replace the number "1" with the server method for getting the name of friends.
//        weeklyseries.getData().add(new XYChart.Data("2", 10));
//        weeklyseries.getData().add(new XYChart.Data("3", 12));
//        weeklyseries.getData().add(new XYChart.Data("4", 2));
//        weeklyseries.getData().add(new XYChart.Data("5", 15));
        Leaderboard.getData().addAll(weeklyseries);

    }


}
