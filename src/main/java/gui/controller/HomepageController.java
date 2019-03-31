package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HomepageController {
    @FXML
    private AnchorPane rootpane;

    /**
     * GUI people please add your comments.
     * @param event .
     * @throws Exception .
     */
    public void clickyourprogress(ActionEvent event) throws Exception {

        Parent secondview;
        secondview = FXMLLoader.load(getClass().getResource("YourProgress.fxml"));
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);


public class HomepageController {
	@FXML
	private AnchorPane rootpane;
	
public void ClickYourProgress(ActionEvent event) throws Exception {
		
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("YourProgress.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
	
		
	}

public void ClickAboutTheApp(ActionEvent event) throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("AboutTheAppVideo.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
public void FoodClicked() throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("Food.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
public void EnergyClicked() throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("Energy.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
public void TransportClicked() throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("Transport.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
public void ClickLeaderboard(ActionEvent event) throws Exception {
	
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("Leaderboard.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
	
		
	}
	
}







