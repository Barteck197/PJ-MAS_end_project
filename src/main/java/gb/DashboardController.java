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
import model.Server;
import utils.ObjectPlus;

import java.util.ArrayList;
import java.util.Objects;

public class DashboardController {

    @FXML
    private Button addServerButton;

/*    Computer computer = new Computer(2.4, 16, 256, "Windows 11");

    Rack rack = new Rack(LocalDate.of(2022, 11, 26), "Enoc System", "NS6618", 613414, 2, true,
            LocalDate.of(2022, 12, 01), 187, 60, 60, 19);
    Server server1;

    {
        try {
            server1 = Server.CreateServer(LocalDate.of(2023, 01, 20), "Dell", "PowerEdge R250", 32450, 2, true,
                    LocalDate.of(2023, 02, 01), 4, 64, rack, 1, computer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }*/

    @FXML
    private TableView<Server> serverTableView = new TableView<>();
    private ObservableList<Server> serverObservableList = FXCollections.observableArrayList();

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
    public void initialize() throws Exception{
        ArrayList<Server> servers = (ArrayList<Server>) ObjectPlus.getExtent(Server.class);
        serverObservableList.addAll(servers);
        serverTableView.setItems(serverObservableList);
    }

    @FXML
    void addServerButtonClicked(ActionEvent event) {
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

    @FXML
    void viewRackList(ActionEvent event){
        try {
            Parent nextView = FXMLLoader.load(getClass().getResource("rack-list-view.fxml"));
            Scene nextScene = new Scene(nextView);

            Stage currentStage = (Stage) serverTableView.getScene().getWindow();
            currentStage.setScene(nextScene);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @FXML
    void editServerButtonClicked(ActionEvent event) {
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

    @FXML
    void deleteServer(ActionEvent event){

    }
}
