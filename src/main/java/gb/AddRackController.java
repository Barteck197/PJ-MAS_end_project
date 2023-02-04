package gb;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AddRackController {

    @FXML
    private Button discardChanges;

    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) discardChanges.getScene().getWindow();
        stage.close();
    }
}
