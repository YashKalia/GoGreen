package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import client.Client;
public class AddingMealController {
	
	@FXML
	private Label lblMeal;
	
	public void addmeal (ActionEvent event) {
		try {
			Client.addEntry(Client.vegetarianmeal, Client.getUser());
		} catch (Exception e) {

		}
		try {
			lblMeal.setText("You've had " + Client.getVeganMealCount(Client.getUser()) + " vegetarian meals!");
		} catch (Exception e) {

		}
	}

}
