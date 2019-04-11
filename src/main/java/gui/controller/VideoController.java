package gui.controller;

import java.io.File;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class VideoController implements Initializable {

	@FXML
	private MediaView mv;
	@FXML
	private Button Back;

	private MediaPlayer mp;
	private Media me;

	@FXML
	private AnchorPane Rootpane;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		String path = new File("src/main/java/gui/resources/AboutApp.mp4").getAbsolutePath();
		me = new Media(new File(path).toURI().toString());
		mp = new MediaPlayer(me);
		mv.setMediaPlayer(mp);
		mp.setAutoPlay(true);
		DoubleProperty height = mv.fitHeightProperty();
		DoubleProperty width = mv.fitWidthProperty();
		width.bind(Bindings.selectDouble(mv.sceneProperty(), "width"));
		height.bind(Bindings.selectDouble(mv.sceneProperty(), "height"));

	}

	public void Back() throws Exception {
		mp.stop();
		Parent secondview;
        @SuppressWarnings("deprecation")
		URL url = new File("src/main/java/gui/fxml/Homepage.fxml").toURL();
        secondview = FXMLLoader.load(url);
        Scene newscene = new Scene(secondview);
        Stage curstage = (Stage) Rootpane.getScene().getWindow();
        curstage.setScene(newscene);
	}
}
