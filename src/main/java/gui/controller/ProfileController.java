package gui.controller;

import client.Client;
import entity.Friends;
import entity.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.web.client.HttpServerErrorException;

import javax.swing.*;
import java.io.File;
import java.net.URL;

import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;


public class ProfileController implements Initializable {
    @FXML
    private AnchorPane rootpane;

    @FXML
    private Label usernamelabel;

    @FXML
    private VBox vbox1;

    @FXML
    private VBox vbox2;

    @FXML
    private HBox hbox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usernamelabel.setText("Username: " + Client.getUser().getUsername());
        HashSet<String> allBadges = Client.getAllBadges(Client.getUrl(),Client.getUser(), Client.getRestTemplate());
        HashSet<String> myBadges = Client.getMyBadges(Client.getUrl(), Client.getUser(), Client.getRestTemplate());
        System.out.println(allBadges.toString());
        System.out.println(myBadges.toString());

        for (String badge : allBadges){
            Label label = new Label(badge);
            String[] splitBadge = badge.split(" ");
            if (splitBadge[0].equals("First")){
                label.setText("1 time " + badge.replaceAll("First ", ""));
            }
            else if (splitBadge[0].equals("Bronze")){
                label.setText("5 times " + badge.replaceAll("Bronze ", ""));
            }
            else if (splitBadge[0].equals("Silver")){
                label.setText("20 times " + badge.replaceAll("Silver ", ""));
            }
            else if (splitBadge[0].equals("Gold")){
                label.setText("50 times " + badge.replaceAll("Gold ", ""));
            }

            if (myBadges.contains(badge)){
                label.setStyle("-fx-text-fill: #d2ad00;");
            }
            vbox1.getChildren().add(label);



        }


    }


    /**
     * Opens up the your progress page inside the window.
     *
     * @param event onClick
     * @throws Exception in case the file isn't found
     */
    public void clickyourprogress(ActionEvent event) throws Exception {

        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/YourProgress.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the about the app page inside the window.
     *
     * @param event onClick
     * @throws Exception in case the file isn't found
     */
    public void clickabouttheapp(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/AboutTheAppVideo.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the leaderboard page inside the current window.
     *
     * @param event clickity click
     * @throws Exception in case the fxml file is not found
     */

    public void clickleaderboard(ActionEvent event) throws Exception {

        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Leaderboard.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);

    }

    /**
     * Opens up the homepage inside the current window.
     *
     * @param event button click
     * @throws Exception if file can't be found
     */

    public void clickhomepage(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Homepage.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    public void clickfriends(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Friends.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }






}







