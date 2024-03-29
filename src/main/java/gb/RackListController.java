package gb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Rack;
import utils.ObjectPlus;

import java.util.ArrayList;

public class RackListController {

    @FXML
    private TableView<Rack> rackTableView = new TableView<>();
    private ObservableList<Rack> rackObservableList = FXCollections.observableArrayList();

    @FXML
    public void initialize() throws Exception {
        ArrayList<Rack> racks = (ArrayList<Rack>) ObjectPlus.getExtent(Rack.class);
        rackObservableList.addAll(racks);
        rackTableView.setItems(rackObservableList);

        rackTableView.setOnMouseClicked(mouseEvent -> {
            if (mouseEvent.getClickCount() == 2) {
                try {
                    showRack(rackTableView.getSelectionModel().getSelectedItem());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @FXML
    void viewServerList() {
        try {
            Parent nextView = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Scene nextScene = new Scene(nextView);

            Stage currentStage = (Stage) rackTableView.getScene().getWindow();
            currentStage.setScene(nextScene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void showRack(Rack rack) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rack-view.fxml"));
        // Podczas ładowania nowego okna w konstruktorze przekazujemy obiekt szafy do wyświetlenia
        loader.setControllerFactory(controller -> new RackController(rack));
        Pane myPane = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(myPane));
        newStage.show();
    }

    @FXML
    void addRackButtonClicked() throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rack-view.fxml"));
        Pane myPane = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(myPane));
        newStage.show();
    }

    @FXML
    void deleteRackButtonClicked(ActionEvent event) {
        // TODO - usuwanie szafy rack
    }
}
