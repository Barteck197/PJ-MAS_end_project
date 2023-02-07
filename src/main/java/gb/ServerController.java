package gb;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Computer;
import model.Rack;
import model.Server;

public class ServerController {

    private Server viewServer;

    @FXML private Button serverSaveForm;
    @FXML private Button serverExitForm;

    // Device fields
    @FXML private DatePicker devicePurchaseDate;
    @FXML private TextField deviceBrand;
    @FXML private TextField deviceModel;
    @FXML private TextField deviceSerialNumber;
    @FXML private TextField deviceAmortizationTime;
    @FXML private RadioButton deviceInUse;

    @FXML private DatePicker deviceInstalationTime;

    // Server fields
    @FXML private TextField serverMountedDisks;
    @FXML private TextField serverMaxRAMMemory;
//    @FXML private Rack serverRack;
    @FXML private TextField serverPositionInRack;
//    @FXML private Computer serverComputer;

    public ServerController(Server viewServer) {
        this.viewServer = viewServer;
    }

    @FXML
    public void initialize() {
        setServer(viewServer);
    }

    @FXML
    void setServer(Server server){
        devicePurchaseDate.setValue(server.getDevicePurchaseDate());
        deviceBrand.setText(server.getDeviceBrand());
        deviceModel.setText(server.getDeviceModel());
        deviceSerialNumber.setText(String.valueOf(server.getDeviceSerialNumber()));
        deviceAmortizationTime.setText(String.valueOf(server.getDeviceAmortizationTime()));
        deviceInUse.setSelected(server.isDeviceInUse());
        deviceInstalationTime.setValue(server.getServerDeviceMountDate());

        serverMountedDisks.setText(String.valueOf(server.getServerMountedDisks()));
        serverMaxRAMMemory.setText(String.valueOf(server.getServerMaxRAMMemory()));
    }


    @FXML
    private void validateForm(ActionEvent event) {
        System.out.println(devicePurchaseDate.getValue());
        addNewServer(event);
    }

    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) devicePurchaseDate.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void addNewServer(ActionEvent event) {
        ObservableList<Server> servers;
//        servers.add(new Server())
    }
}
