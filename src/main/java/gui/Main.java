package application;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
   
        try {

            File file=new File("src/main/java/gui/fxml/MainFXML.fxml");
            URL url = file.toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(getClass()
            // .getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.sizeToScene();
            primaryStage.show();
      
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        launch(args);
    }
}
