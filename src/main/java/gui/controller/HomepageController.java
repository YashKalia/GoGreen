package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class HomepageController {
    @FXML
    private AnchorPane rootpane;
    private Stage primaryStage;


    /**
     * Opens up the your progress page inside the window.
     *
     * @param event onClick
     * @throws Exception in case the file isn't found
     */
    @SuppressWarnings("deprecation")
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
    @SuppressWarnings("deprecation")
    public void clickabouttheapp(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/AboutTheAppVideo.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the food page inside the window.
     *
     * @throws Exception in case the file isn't found
     */
    @SuppressWarnings("deprecation")
    public void foodclicked() throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Food.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the energy page inside the window.
     *
     * @throws Exception in case the file isn't found
     */
    @SuppressWarnings("deprecation")
    public void energyclicked() throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Energy.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the transport page inside the window.
     *
     * @throws Exception in case the file isn't found
     */
    @SuppressWarnings("deprecation")
    public void transportclicked() throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Transport.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the leaderboard page inside the current window.
     *
     * @param event click click click
     * @throws Exception in case the fxml file is not found
     */

    @SuppressWarnings("deprecation")
    public void clickleaderboard(ActionEvent event) throws Exception {

        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Leaderboard.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);



    }

    /**
     * Opens the friends page.
     *
     * @param event clicks
     * @throws Exception oops
     */
    @SuppressWarnings("deprecation")
    @FXML
    public void clickfriends(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Friends.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    @FXML
    public void clickyourprofile(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Profile.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);

    /**Logs out the user.
     *
     * @param event activated on mouse click.
     */
    @FXML
    public void logOut(ActionEvent event) {
        try {
            String pathname = "src/main/java/gui/fxml/MainFXML.fxml";
            File file = new File(pathname);
            URL url = file.toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            scene.getStylesheets()
                    .add(getClass().getResource("/gui/application.css")
                            .toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.sizeToScene();
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}







