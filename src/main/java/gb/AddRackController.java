package gb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Rack;
import model.Server;
import utils.ObjectPlus;

import java.time.LocalDate;
import java.util.ArrayList;

public class AddRackController {

    // Device fields
    @FXML
    private DatePicker devicePurchaseDate;
    @FXML
    private TextField deviceBrand;
    @FXML
    private TextField deviceModel;
    @FXML
    private TextField deviceSerialNumber;
    @FXML
    private TextField deviceAmortizationTime;
    @FXML
    private RadioButton deviceInUse;

    @FXML
    private DatePicker deviceInstalationTime;

    // Rack fields
    @FXML
    private TextField rackVolume;
    @FXML
    private TextField rackHeight;
    @FXML
    private TextField rackDepth;
    @FXML
    private TextField rackWidth;

    @FXML
    private ListView<Server> rackServers = new ListView<>();
    private ObservableList<Server> rackServersObservableList = FXCollections.observableArrayList();

    @FXML
    private Button discardChanges;

    @FXML
    public void initialize() throws Exception {
        /*ArrayList<Server> servers = (ArrayList<Server>) ObjectPlus.getExtent(Server.class);
        rackServersObservableList.addAll(servers);
        rackServers.setItems(rackServersObservableList);*/
    }

    @FXML
    private void validateForm() {
//        Rack newRack = new Rack(devicePurchaseDate.getValue(),
//                deviceBrand.getText(),
//                deviceModel.getText(),
//                deviceSerialNumber.getText(),
//                deviceAmortizationTime.getText(),
//                deviceInUse.equals(true),
//                deviceInstalationTime.getValue(),
//                rackHeight.getText(),
//                rackWidth.getText(),
//                rackDepth.getText(),
//                rackVolume.getText());
    }

    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) discardChanges.getScene().getWindow();
        stage.close();
    }
}
