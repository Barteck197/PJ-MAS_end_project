package gb;

import javafx.beans.Observable;
import javafx.beans.property.Property;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import model.Computer;
import model.Rack;
import model.Server;

import java.time.LocalDate;
import java.util.Objects;

public class DashboardController {

    @FXML
    private Button addServerButton;

    Computer computer = new Computer(2.4, 16, 256, "Windows 11");

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
    }


    ObservableList<Server> servers = FXCollections.observableArrayList(server1);

    @FXML
    private TableView<Server> serverTableView;

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

    public DashboardController() {
        serverTableView = new TableView<>();
//        serverTableView.setEditable(false);
//
        serverId = new TableColumn<>("Id serwera");
        serverBrand = new TableColumn<>("Marka");
        serverModel = new TableColumn<>("Model");
        serverNrOfDisks = new TableColumn<>("Dyski");
        serverRamMemory = new TableColumn<>("RAM");
        serverPosition = new TableColumn<>("poz. w szafie rack");
//
        serverId.setCellValueFactory(new PropertyValueFactory<>("Id serwera"));
        serverBrand.setCellValueFactory(new PropertyValueFactory<>("Marka"));
        serverModel.setCellValueFactory(new PropertyValueFactory<>("Model"));
        serverNrOfDisks.setCellValueFactory(new PropertyValueFactory<>("Dyski"));
        serverRamMemory.setCellValueFactory(new PropertyValueFactory<>("RAM"));
        serverPosition.setCellValueFactory(new PropertyValueFactory<>("poz. w szafie rack"));

        serverTableView.setItems(servers);
//        serverTableView.getColumns().addAll(serverId, serverBrand, serverModel, serverNrOfDisks, serverRamMemory, serverPosition);
//        System.out.println(servers.get(0));
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
}
