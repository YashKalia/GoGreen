import client.Client;
import entity.Friends;
import entity.User;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

import java.util.HashSet;
import java.util.ResourceBundle;


public class FriendsController implements Initializable {
    @FXML
    private AnchorPane rootpane;
    @FXML
    private Button friendsButton;

    @FXML
    private TitledPane ReceivedInvites;

    @FXML
    private TextField FriendSearch;

    @FXML
    private Button FriendSearchButton;

    @FXML
    private VBox vbox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        HashSet<String> friendRequests = Client.getPendingRequests(Client.getUrl(), Client.getUser(), Client.getRestTemplate());
        for (String friendRequest : friendRequests){
            Button b1 = new Button(friendRequest);
            vbox.getChildren().add(new ToolBar(new Label("Accept Invite"), b1));
            b1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    User friend = new User(b1.getText(),null);
                    Friends newFriend = new Friends(Client.getUser(),friend);
                    if(Client.addFriend(Client.getUrl(),newFriend,Client.getRestTemplate())) {
                        b1.setText("Invite Accepted");
                    }
                    else{
                        b1.setText("Accept Failed");
                    }
                }
            });

        }

    }


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
     * Opens up the leaderboard page inside the current window
     * @param event
     * @throws Exception in case the fxml file is not found
     */

    public void clickleaderboard(ActionEvent event) throws Exception {

	    Parent secondview;
	    URL url = new File("src/main/java/gui/fxml/Leaderboard.fxml").toURL();
 	    secondview = FXMLLoader.load(url);
	    Scene newscene = new Scene(secondview);
	    Stage curstage = (Stage) rootpane.getScene().getWindow();
	    curstage.setScene(newscene);


	}

	@FXML
    void addFriend(ActionEvent event){
        User friend = new User(FriendSearch.getText(),null);
        Friends newFriend = new Friends(Client.getUser(),friend);
        if (Client.addFriend(Client.getUrl(),newFriend,Client.getRestTemplate())) {
            FriendSearchButton.setText("Friend Added");
        }
        else {
            FriendSearchButton.setText("User invalid");
        }
    }



}







