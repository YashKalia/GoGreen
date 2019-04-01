import client.Client;
import entity.Feature;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class EnergyController {

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button clickhome;

    @FXML
    private Button solarpanel;

    @FXML
    private Button getsolarpanel;

    @FXML
    private Button gettemperature;

    @FXML
    private Button temperature;

    @FXML
    void clickhome(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Homepage.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    @FXML
    void solarpanel(ActionEvent event) {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Installing solar panels"), Client.getRestTemplate())) {
            solarpanel.setText("Thanks for your submission!");
        }
    }

    @FXML
    void getsolarpanel(ActionEvent event) {
        getsolarpanel.setText("You've installed a total of "
                + Integer.toString(Client.getSolarPanels(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " solar panels. Click to update.");
    }

    @FXML
    void gettemperature(ActionEvent event) {
        gettemperature.setText("You've lowered the temperature of your home "
                + Integer.toString(Client.getLoweringTemperature(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times. Click to update.");
    }

    @FXML
    void temperature(ActionEvent event) {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Lowering the temperature of your home"), Client.getRestTemplate())) {
            temperature.setText("Thanks for your submission!");
        }
    }

}
