package gb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Rack;
import model.Server;
import utils.ObjectPlus;

import java.util.ArrayList;
import java.util.Objects;

public class RackListController {

    @FXML
    private TableView<Rack> rackTableView = new TableView<>();
    private ObservableList<Rack> rackObservableList = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Rack, Integer> rackID;
    @FXML
    private TableColumn<Rack, String> rackBrand;
    @FXML
    private TableColumn<Rack, String> rackModel;
    @FXML
    private TableColumn<Rack, Integer> rackSerialNumber;
    @FXML
    private TableColumn<Rack, Boolean> rackInUse;

    @FXML
    public void initialize() throws Exception{
        ArrayList<Rack> racks = (ArrayList<Rack>) ObjectPlus.getExtent(Rack.class);
        rackObservableList.addAll(racks);
        rackTableView.setItems(rackObservableList);
    }

    @FXML
    void viewServerList(ActionEvent event){
        try {
            Parent nextView = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Scene nextScene = new Scene(nextView);

            Stage currentStage = (Stage) rackTableView.getScene().getWindow();
            currentStage.setScene(nextScene);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void addRackButtonClicked(ActionEvent event) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("add-rack-view.fxml")));

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 680, 480));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void editRackButtonClicked(ActionEvent event) {
        // TODO - edycja szafy rack
    }

    @FXML
    void deleteRackButtonClicked(ActionEvent event){
        // TODO - usuwanie szafy rack
    }

    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) rackTableView.getScene().getWindow();
        stage.close();
    }
}
