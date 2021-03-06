package gui.controller;

import client.Client;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.springframework.web.client.HttpClientErrorException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MainController {

    private static User user;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtUsername;

    @FXML
    private Label lblStatus;

    @FXML
    private AnchorPane rootpane;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        MainController.user = user;
    }


    /**
     * Tries to log in a user.
     * If the response of the client is the boolean true, the username and password are correct.
     * Then, the local variable user is update with the credentials,
     * And a new screen is brought up.
     * Otherwise, an error message is displayed.
     *
     * @param event on click
     * @throws Exception HUGE OFF
     */
    @SuppressWarnings("deprecation")
    public void login(ActionEvent event) throws IOException {

        User newuser = new User(txtUsername.getText(), txtPassword.getText());
        Client.setUser(newuser);
        try {
            Client.enableBasicAuthentication();
            if (Client.sendLoginRequest(Client.getUrl(), newuser, Client.getRestTemplate())) {
                lblStatus.setText("Login Success");
                Stage primaryStage = new Stage();
                URL url = new File("src/main/java/gui/fxml/Homepage.fxml").toURL();
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                primaryStage.setScene(scene);
                primaryStage.show();
                Stage firstStage = (Stage) txtUsername.getScene().getWindow();
                firstStage.close();


            } else {
                lblStatus.setText("Bad Credentials");
            }
        } catch (IOException e) {
            lblStatus.setText("Error in creating a new request!");
        } catch (HttpClientErrorException e) {
            lblStatus.setText("Invalid credentials!");
        }
    }

    /**
     * Empty for now, just brings up new screen.
     *
     * @param event on click
     * @throws IOException GIGANTIC OOF
     */
    @SuppressWarnings("deprecation")
    public void register(ActionEvent event) throws IOException {

        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Register.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);

    }

}
