package gb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.Objects;

public class DashboardController {

    @FXML
    private Button addServerButton;

    @FXML
    void addServerButtonClicked(ActionEvent event){
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-server-view.fxml")));

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 680, 480));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void editServerButtonClicked(ActionEvent event){
/*        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-server-view.fxml")));

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 680, 480));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
