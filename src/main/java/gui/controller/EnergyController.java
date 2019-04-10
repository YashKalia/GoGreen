package gui.controller;

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

import java.io.File;
import java.net.URL;

public class EnergyController {

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button clickhome;

    

    @FXML
    private Button getsolarpanel;

    @FXML
    private Button gettemperature;

    @FXML
    private Button temperature;
    
     @FXML
    private Label lowflow;
    
    
    

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
    void solarpanel() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Installing solar panels"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            
        }
        else {
        	lowflow.setText("Registered!");
        }
    }

    @FXML
    void getsolarpanel(ActionEvent event) {
        lowflow.setText("A total of "
                + Integer.toString(Client.getSolarPanels(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " solar panels.");
    }

    @FXML
    void gettemperature(ActionEvent event) {
        lowflow.setText("Lowered "
                + Integer.toString(Client.getLoweringTemperature(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times.");
    }

    @FXML
    void temperature() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Washing your clothes with cold water"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            
        }
        else {
        	lowflow.setText("Registered!");
        }
    }
    
    @FXML
    void coldwash() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Cold water laundry"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            
        }
        else {
        	lowflow.setText("Registered!");
        }
    }
    
    @FXML
    void getcoldwash(ActionEvent event) {
        lowflow.setText("Used cold water "
                + Integer.toString(Client.getcoldwashnumber(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times.");
    }
    
    @FXML
    void lowflow() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Installing slow-flow showerhead"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            
        }
        else {
        	lowflow.setText("Registered!");
        }
    }
    
    @FXML
    void getlowflow(ActionEvent event) {
    	 getlowflow.setText("Used cold water "
                 + Integer.toString(Client.getlowflow(Client.getUrl(),
                 Client.getUser(), Client.getRestTemplate())) + " times.");
    }
    

}
