import client.Client;

import entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class RegisterController {

    @FXML
    private Label lblregisterstatus;

    @FXML
    private TextField passwordfield;

    @FXML
    private TextField passwordconfirm;

    @FXML
    private TextField usernamefield;

    /**
     * Checks if the first password supplied by the user matches the second one.
     *
     * @param event on Button click
     */
    public void checkregistration(ActionEvent event) throws InterruptedException {
        if (passwordfield.getText().equals(passwordconfirm.getText())) {
            User newUser = new User(usernamefield.getText(), passwordfield.getText());
            String str = Client.register(Client.getUrl(), newUser, Client.getRestTemplate());
            if (str.equals("Registration successful")) {
                Client.setUser(newUser);
                lblregisterstatus.setText("Registration Confirmed");
                TimeUnit.SECONDS.sleep(2);
                Stage firstStage = (Stage) passwordfield.getScene().getWindow();
                firstStage.close();
            } else {
                lblregisterstatus.setText(str);
            }
        } else {
            lblregisterstatus.setText("Password Do Not Match");
        }
    }


}
