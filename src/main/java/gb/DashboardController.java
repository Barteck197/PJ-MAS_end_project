package gb;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Server;
import utils.ObjectPlus;

import java.util.ArrayList;
import java.util.Objects;

public class DashboardController {

    @FXML
    private Button addServerButton;

    @FXML
    private TableView<Server> serverTableView = new TableView<>();

    @FXML
    private TableColumn<Server, Integer> serverId;
    @FXML
    private TableColumn<Server, String> serverBrand;
    @FXML
    private TableColumn<Server, String> serverModel;
    @FXML
    private TableColumn<Server, Integer> serverNrOfDisks;
    @FXML
    private TableColumn<Server, Integer> serverRamMemory;
    @FXML
    private TableColumn<Server, Integer> serverPosition;

    @FXML
    public void initialize() throws Exception {
        ArrayList<Server> servers = (ArrayList<Server>) ObjectPlus.getExtent(Server.class);
        ObservableList<Server> serverObservableList = FXCollections.observableArrayList(servers);
        serverTableView.setItems(serverObservableList);

        serverTableView.getSelectionModel().selectedItemProperty().addListener((observableValue, server, t1) -> {
            try {
                showServer(t1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    @FXML
    protected void showServer(Server server) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("server-view.fxml"));
        // Podczas ładowania nowego okna w konstruktorze przekazujemy obiekt książki do wyświetlenia
        loader.setControllerFactory(controller -> new ServerController(server));
        Pane myPane = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(myPane));
        newStage.show();
    }

    @FXML
    void addServerButtonClicked(ActionEvent event) {
        try {
            // Load the FXML file
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("server-view.fxml")));

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 680, 480));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void viewRackList(ActionEvent event) {
        try {
            Parent nextView = FXMLLoader.load(getClass().getResource("rack-list-view.fxml"));
            Scene nextScene = new Scene(nextView);

            Stage currentStage = (Stage) serverTableView.getScene().getWindow();
            currentStage.setScene(nextScene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void deleteServer(ActionEvent event) {

    }
}
