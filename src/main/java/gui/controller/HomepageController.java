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
	
public void clickyourprogress(ActionEvent event) throws Exception {
		
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("YourProgress.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
	
		
	}

public void clickabouttheapp(ActionEvent event) throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("AboutTheAppVideo.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
public void foodclicked() throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("Food.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
public void energyclicked() throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("Energy.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
public void transportclicked() throws Exception {
	Parent secondview;
	secondview = FXMLLoader.load(getClass().getResource("Transport.fxml"));
	Scene newscene = new Scene(secondview);
	Stage curstage = (Stage) rootpane.getScene().getWindow();
	curstage.setScene(newscene);
    }
	
}







