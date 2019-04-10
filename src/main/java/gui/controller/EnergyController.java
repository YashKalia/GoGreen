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
    private Button solarpanel;

    @FXML
    private Button getsolarpanel;

    @FXML
    private Button gettemperature;

    @FXML
    private Button temperature;
    
    @FXML
    private Label lowtemplabel;
    
    @FXML
    private Label gettempcount;
    
    @FXML
    private Label sp;
    
    @FXML
    private Label getsp;
    
    @FXML
    private Label coldwater;
    
    @FXML
    private Label getcoldwater;
    
    @FXML
    private Label lowflow;
    
    @FXML
    private Label getlowflow;
    

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
        	sp.setText("Registered!");
        }
    }

    @FXML
    void getsolarpanel(ActionEvent event) {
        getsp.setText("A total of "
                + Integer.toString(Client.getSolarPanels(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " solar panels.");
    }

    @FXML
    void gettemperature(ActionEvent event) {
        gettempcount.setText("Lowered "
                + Integer.toString(Client.getLoweringTemperature(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times.");
    }

    @FXML
    void temperature() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Lowering the temperature of your home"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            
        }
        else {
        	lowtemplabel.setText("Registered!");
        }
    }
    
    @FXML
    void coldwash() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Washing your clothes with cold water"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            
        }
        else {
        	coldwater.setText("Registered!");
        }
    }
    
    @FXML
    void getcoldwash(ActionEvent event) {        
        getcoldwater.setText("Used cold water "
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
    	 getlowflow.setText("Installed "
                 + Integer.toString(Client.getlowflow(Client.getUrl(),
                 Client.getUser(), Client.getRestTemplate())) + " times.");
    }
    

}
