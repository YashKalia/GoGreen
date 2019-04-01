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

public class FoodController {

    @FXML
    private Button clickhome;

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button vegeteraininin;

    @FXML
    private Button locolproduce;

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
    void locolproduce(ActionEvent event) {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Buying local produce"), Client.getRestTemplate())) {
            locolproduce.setText("Thanks for your submission!");
        }
    }

    @FXML
    void vegeteraininin(ActionEvent event) {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Eating a vegetarian meal"), Client.getRestTemplate())) {
            vegeteraininin.setText("Thanks for your submission!");
        }

    }

}
