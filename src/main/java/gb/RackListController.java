package gb;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Rack;
import model.Server;
import utils.ObjectPlus;

import java.security.spec.ECField;
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

/*        rackTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, rack, t1) -> {
            try {
                showRack(t1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
    }

    @FXML
    void viewServerList(ActionEvent event) {
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
        // Podczas ładowania nowego okna w konstruktorze przekazujemy obiekt książki do wyświetlenia
        loader.setControllerFactory(controller -> new RackController(rack));
        Pane myPane = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(myPane));
        newStage.show();
    }

    @FXML
    void addRackButtonClicked(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rack-view.fxml"));
        // Podczas ładowania nowego okna w konstruktorze przekazujemy obiekt książki do wyświetlenia
        Pane myPane = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(myPane));
        newStage.show();
    }

    @FXML
    void editRackButtonClicked(ActionEvent event) {
        // TODO - edycja szafy rack
    }

    @FXML
    void deleteRackButtonClicked(ActionEvent event) {
        // TODO - usuwanie szafy rack
    }

    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) rackTableView.getScene().getWindow();
        stage.close();
    }
}
