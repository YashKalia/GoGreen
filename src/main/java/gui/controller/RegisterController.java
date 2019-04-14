package gui.controller;

import client.Client;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class RegisterController {

    @FXML
    private Label lblregisterstatus;

    @FXML
    private TextField passwordfield;

    @FXML
    private TextField passwordconfirm;

    @FXML
    private TextField usernamefield;

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button home;

    /**
     * Checks if the first password supplied by the user matches the second one.
     *
     * @param event on Button click
     * @throws Exception 
     */
    public void checkregistration(ActionEvent event) throws InterruptedException, Exception {
        if (passwordfield.getText().equals(passwordconfirm.getText())) {
            User newUser = new User(usernamefield.getText(), passwordfield.getText());
            String str = Client.register(Client.getUrl(), newUser, Client.getRestTemplate());
            if (str.equals("Registration successful")) {
                Parent secondview;
            	Client.setUser(newUser);
                lblregisterstatus.setText("Registration Confirmed");
                TimeUnit.SECONDS.sleep(2);
                URL url = new File("src/main/java/gui/fxml/MainFXML.fxml").toURL();
                secondview = FXMLLoader.load(url);
                Scene newscene = new Scene(secondview);
                Stage curstage = (Stage) rootpane.getScene().getWindow();
                curstage.setScene(newscene);
                
            } else {
                lblregisterstatus.setText(str);
            }
        } else {
            lblregisterstatus.setText("Password Do Not Match");
        }
    }

    @FXML
    void clickhome(ActionEvent event) throws Exception {
        Parent secondview;
        @SuppressWarnings("deprecation")
        URL url = new File("src/main/java/gui/fxml/MainFXML.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }


}
