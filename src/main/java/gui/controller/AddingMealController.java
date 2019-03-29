//package gui.controller;
//
//import client.Client;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.scene.control.Label;
//import org.json.JSONException;
//
//import java.io.IOException;
//
//public class AddingMealController {
//    @FXML
//    private Label lblMeal;
//
//    @FXML
//    private Label getMeals;
//
//    /**
//     * Adds an entry with a vegan meal to the user stored in the client code.
//     *
//     * @param event on click.
//     */
//    public void addmeal(ActionEvent event) {
//        try {
//            Client.addEntry(Client.vegetarianmeal, Client.getUser());
//            if (Client.getVegetarianMealCount(Client.getUser()) != 0) {
//                lblMeal.setText("Meal added successfully!");
//            }
//        } catch (IOException e) {
//            lblMeal.setText("Something went wrong!");
//        } catch (JSONException e) {
//            getMeals.setText("Couldn't send your request");
//        }
//    }
//
//    /**
//     * Counts the number of the user stored in the client class has had in total.
//     *
//     * @param event on click.
//     */
//    public void getMeals(ActionEvent event) {
//
//        try {
//            getMeals.setText("You've had "
//                    + Client.getVegetarianMealCount(Client.getUser())
//                    + " vegetarian meals!");
//        } catch (IOException e) {
//            getMeals.setText("Something went wrong! Please try again!");
//        } catch (JSONException e) {
//            getMeals.setText("Couldn't send your request");
//        }
//    }
//}
//
