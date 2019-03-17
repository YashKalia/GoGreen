package gui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import client.Client;
public class AddingMealController {
	
	@FXML
	private Label lblMeal;

	@FXML
	private Label getMeals;

	public void addmeal (ActionEvent event) {
		try {
			Client.addEntry(Client.vegetarianmeal, Client.getUser());
			if(Client.getVeganMealCount(Client.getUser())!=0) {
				lblMeal.setText("Meal added successfully!");
			}
		} catch (Exception e) {

		}
	}

	public void getMeals(ActionEvent event) {

		try {
			getMeals.setText("You've had " + Client.getVeganMealCount(Client.getUser()) + " vegetarian meals!");
		} catch (Exception e) {

		}
	}
}

