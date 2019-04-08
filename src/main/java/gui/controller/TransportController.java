package gui.controller;

import java.io.File;
import java.net.URL;

import client.Client;
import entity.Feature;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TransportController {
	
    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button clickhome;
    
    @FXML
    private Label trainlabel;
    
    @FXML
    private Label cyclelabel;
    @FXML
    private Label treglabel;
    @FXML
    private Label creglabel;
    
    
    @SuppressWarnings("deprecation")
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
    void usedtrain() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Using public transport instead of car"), Client.getRestTemplate()).equals("Entry added successfully")) {
    		treglabel.setText("Registered!!");
    	}
    	
    }
    
    @FXML
    void getUsedTrain(ActionEvent event) {
    	trainlabel.setText("You've taken the train "
                + Integer.toString(Client.getPublicTransport(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times.");
    }
    
    @FXML
    void cycledtowork() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Using bike instead of car"), Client.getRestTemplate()).equals("Entry added successfully")) {
    		creglabel.setText("Registered!!");
    	}
    }
    
    @FXML
    void getCycles(ActionEvent event) {
    	cyclelabel.setText("You've cycled to work  "
                + Integer.toString(Client.getBikeRides(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times.");
    }
    

}
