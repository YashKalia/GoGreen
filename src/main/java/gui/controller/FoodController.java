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
    private Label treecount;

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
            treecount.setText("Submitted!");

        }
    }

    @FXML
    void getlocalproduce() {
        treecount.setText("You have bought Local Produce "
                + (Client.getLocalProduce(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " " + "Times.");
    }

    @FXML
    void getvegetarian() {
        treecount.setText("You've had "
                + (Client.getVegetarianMeals(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " " + "Vegetarian Meals.");
    }

    @FXML
    void gettreecount() {
        treecount.setText("You've planted "
                + (Client.gettreepLanted(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " Trees");

    }

    @FXML
    void addvegetarian() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Eating a vegetarian meal"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            treecount.setText("Submitted!");
        }


    }

    @FXML
    void addtreeplanted() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Planting a tree"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            treecount.setText("Submitted!");
        }
    }


    @FXML
    void addrecycle() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Recycling waste"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            treecount.setText("Submitted!");
        }
    }

    @FXML
    void getrecycle() {
        treecount.setText("You've recycled: "
                + (Client.getrecycled(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " " + " times!");
    }

    @FXML
    void veganmeal() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Eating a vegan meal"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            treecount.setText("Submitted!");
        }
    }


    @FXML
    void getveganmeal(ActionEvent event) {
        treecount.setText("You've eaten "
                + Integer.toString(Client.getveganmeal(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " Vegan meals.");
    }

    @FXML
    void secondhand() {
        if (Client.addEntry(Client.getUrl(), Client.getUser(),
                new Feature("Buying second-hand clothing"),
                Client.getRestTemplate()).equals("Entry added successfully")) {
            treecount.setText("Submitted!");
        }
    }

    @FXML
    void getsecondhand() {
        treecount.setText("You've bought second hand clothing "
                + Integer.toString(Client.getsecondhandnumber(Client.getUrl(),
                Client.getUser(), Client.getRestTemplate())) + " times.");
    }
}
