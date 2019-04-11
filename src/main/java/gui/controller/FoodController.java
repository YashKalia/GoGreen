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

public class FoodController {

    @FXML
    private Button clickhome;

    @FXML
    private AnchorPane rootpane;

    @FXML
    private Button getvegetarian;

    @FXML
    private Button getlocalproduce;
    
    @FXML
    private Label meal;
    
    @FXML
    private Label localproduce;
    
    @FXML
    private Label getvegmeals;
    
    @FXML
    private Label localproducecount;
    
    @FXML
    private Label tree;
    
    @FXML
    private Label treecount;
    
    @FXML
    private Label recycle;
    
    @FXML
    private Label recyclecount;
    
    @FXML
    private Label veganmeal;
    
    @FXML
    private Label getveganmeal;
    
    @FXML
    void clickhome(ActionEvent event) throws Exception {
        Parent secondview;
        @SuppressWarnings("deprecation")
		URL url = new File("src/main/java/gui/fxml/Homepage.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    @FXML
    void localproduce() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Buying local produce"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
          
        }
        else {
        	localproduce.setText("Submitted!");
        }
    }

    @FXML
    void getlocalproduce() {
    	localproducecount.setText("bought :"
                + Integer.toString(Client.getLocalProduce(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times.");
    }

    @FXML
    void getvegetarian() {
        getvegmeals.setText("You've had "
                + Integer.toString(Client.getVegetarianMeals(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())));
    }

    @FXML
    void addvegetarian() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Eating a vegetarian meal"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            }
            else {
            	meal.setText("Submitted");
            }

    }
    
    @FXML
    void addtreeplanted() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Planting a tree"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            }
            else {
            	tree.setText("Submitted");
            }
    }
    
    @FXML
    void gettreecount(ActionEvent event) {
    	treecount.setText("You've planted "
                + Integer.toString(Client.gettreepLanted(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate()))+" tree(s)");
    	
    }
    
    @FXML
    void addrecycle() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Recycling waste"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            }
            else {
            	recycle.setText("Submitted");
            }
    }
    
    @FXML
    void getrecycle(ActionEvent event) {
        recyclecount.setText("You recycled:"
                + Integer.toString(Client.getrecycled(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate()))+" times");
    }
    
    

    @FXML
    void veganmeal() {
    	if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Eating a vegan meal"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            
        }
        else {
        	veganmeal.setText("Registered!");
        }
    }
    
    @FXML
    void getveganmeal(ActionEvent event) {
    	 getveganmeal.setText("Ate "
                 + Integer.toString(Client.getveganmeal(Client.getUrl(),
                 Client.getUser(), Client.getRestTemplate())) + " times.");
    }
    

    

}
