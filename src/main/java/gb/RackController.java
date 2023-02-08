package gb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Rack;
import model.Server;
import utils.ObjectPlus;

import java.util.ArrayList;

public class RackController {

    private Rack viewRack;

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

    @FXML
    private Button discardChanges;

    public RackController(Rack viewRack) {
        this.viewRack = viewRack;
    }

    public RackController(){}

    @FXML
    public void initialize() throws Exception {
        if (viewRack != null){
            setViewRack(viewRack);

            ObservableList<Server> rackServersObservableList = FXCollections.
                    observableArrayList(viewRack.getServers());
            rackServers.setItems(rackServersObservableList);
            System.out.println(rackServers.getItems());
        }
    }

    public void setViewRack(Rack rack){
        devicePurchaseDate.setValue(rack.getDevicePurchaseDate());
        deviceBrand.setText(rack.getDeviceBrand());
        deviceModel.setText(rack.getDeviceModel());
        deviceSerialNumber.setText(String.valueOf(rack.getDeviceSerialNumber()));
        deviceAmortizationTime.setText(String.valueOf(rack.getDeviceAmortizationTime()));
        deviceInUse.setSelected(rack.isDeviceInUse());
        deviceInstalationTime.setValue(rack.getServerDeviceMountDate());

        rackVolume.setText(String.valueOf(rack.getRackVolume()));
        rackHeight.setText(String.valueOf(rack.getRackHeight()));
        rackDepth.setText(String.valueOf(rack.getRackLength()));
        rackWidth.setText(String.valueOf(rack.getRackWidth()));
    }



    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) discardChanges.getScene().getWindow();
        stage.close();
    }
}
