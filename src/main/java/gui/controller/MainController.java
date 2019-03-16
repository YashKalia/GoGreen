package gui.controller;

import client.Client;
import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

public class MainController {

	public static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		MainController.user = user;
	}

	@FXML
	private Label lblStatus;

	@FXML
	private TextField txtUsername;

	@FXML
	private TextField txtPassword;

	public void login (ActionEvent event) throws Exception {

		User newuser = new User(txtUsername.getText(),txtPassword.getText());
		if (Client.sendLoginRequest(newuser).equals("true")) {
			Client.setUser(newuser);
			lblStatus.setText("Login Success");
			Stage primaryStage = new Stage();
			URL url = new File("src/main/java/gui/fxml/AddingMeal.fxml").toURL();
			Parent root = FXMLLoader.load(url);
			Scene scene = new Scene(root);
//			scene.getStylesheets().add(getClass().getResource("/gui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();

		} else {
			lblStatus.setText("Bad Credentials");
		}
	}

	public void register (ActionEvent event) throws Exception {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Register.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
