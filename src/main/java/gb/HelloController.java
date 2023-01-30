package gb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

public class HelloController {
    public PasswordField passwordField;
    @FXML
    private Text actionTarget;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        actionTarget.setText("Sign in button pressed");;
    }
}