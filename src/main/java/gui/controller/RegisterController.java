

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private Label lblregisterstatus;

    @FXML
    private TextField passwordfield;

    @FXML
    private TextField passwordconfirm;

    /**
     * Checks if the first password supplied by the user matches the second one.
     * @param event on Button click
     */
    public void checkregistration (ActionEvent event) {
        if (passwordfield.getText().equals(passwordconfirm.getText())) {
            lblregisterstatus.setText("Registration Confirmed");
        } else {
            lblregisterstatus.setText("Password Do Not Match");
        }
    }


}
