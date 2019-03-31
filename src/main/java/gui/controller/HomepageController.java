import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToolBar;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

import java.util.ResourceBundle;


public class HomepageController {
    @FXML
    private AnchorPane rootpane;
    private TitledPane friendsDrop;




    /**
     * Opens up the your progress page inside the window.
     * @param event onClick
     * @throws Exception in case the file isn't found
     */
    public void clickyourprogress(ActionEvent event) throws Exception {

        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/YourProgress.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
<<<<<<< src/main/java/gui/controller/HomepageController.java
    }

    /**
     * Opens up the about the app page inside the window.
     * @param event onClick
     * @throws Exception in case the file isn't found
     */
    public void clickabouttheapp(ActionEvent event) throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/AboutTheAppVideo.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the food page inside the window.
     * @throws Exception in case the file isn't found
     */
    public void foodclicked() throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Food.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the energy page inside the window.
     * @throws Exception in case the file isn't found
     */
    public void energyclicked() throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Energy.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }

    /**
     * Opens up the transport page inside the window.
     * @throws Exception in case the file isn't found
     */
    public void transportclicked() throws Exception {
        Parent secondview;
        URL url = new File("src/main/java/gui/fxml/Transport.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) rootpane.getScene().getWindow();
        curstage.setScene(newscene);
    }
    
    public void ClickLeaderboard(ActionEvent event) throws Exception {
	
	    Parent secondview;
	    URL url = new File("src/main/java/gui/fxml/Leaderboard.fxml").toURL();
 	    secondview = FXMLLoader.load(url);
	    Scene newscene = new Scene(secondview);
	    Stage curstage = (Stage) rootpane.getScene().getWindow();
	    curstage.setScene(newscene);
	
		
	}
}







