package gb;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Rack;
import model.Server;

public class ServerController {

    private Server viewServer;
    // Szafa, której dotyczy serwer
    private Rack viewRack;

    @FXML
    private Button serverSaveForm;
    @FXML
    private Button serverExitForm;

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

    // Server fields
    @FXML
    private TextField serverMountedDisks;
    @FXML
    private TextField serverMaxRAMMemory;
    @FXML
    private TextField serverPositionInRack;

    public ServerController(Server viewServer, Rack viewRack) {
        this.viewServer = viewServer;
        this.viewRack = viewRack;
    }

    public ServerController(Rack viewRack) {
        this.viewRack = viewRack;
    }

//    public ServerController(Server server){ this.viewServer = server;}

    @FXML
    public void initialize() {
        if (viewServer != null) {
            setServer(viewServer);
        }
    }

    @FXML
    void setServer(Server server) {
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

    public void createNewServer() {
        try {
            Server.CreateServer(
                    devicePurchaseDate.getValue(),
                    deviceBrand.getText(),
                    deviceModel.getText(),
                    Long.parseLong(deviceSerialNumber.getText()),
                    Integer.parseInt(deviceAmortizationTime.getText()),
                    deviceInUse.isSelected(),
                    deviceInstalationTime.getValue(),
                    Integer.parseInt(serverMountedDisks.getText()),
                    Integer.parseInt(serverMaxRAMMemory.getText()),
                    viewRack,
                    1
            );


        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Niepoprawne dane.");
            alert.setContentText(ex.getLocalizedMessage());
            alert.show();
        }
    }

    public void saveServerData() {
        if (viewServer == null) {
            createNewServer();
        } else {
            updateServerData();
        }

        closeFormAction();
    }

    public void updateServerData() {
        try {
            viewServer.setDevicePurchaseDate(devicePurchaseDate.getValue());
            viewServer.setDeviceBrand(deviceBrand.getText());
            viewServer.setDeviceModel(deviceModel.getText());
            viewServer.setDeviceAmortizationTime(Integer.parseInt(deviceAmortizationTime.getText()));
            viewServer.setDeviceInUse(deviceInUse.isSelected());
            viewServer.setServerDeviceMountDate(deviceInstalationTime.getValue());
            viewServer.setServerMountedDisks(Integer.parseInt(serverMountedDisks.getText()));
            viewServer.setServerMaxRAMMemory(Integer.parseInt(serverMaxRAMMemory.getText()));
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Niepoprawne dane.");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }


    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) devicePurchaseDate.getScene().getWindow();
        stage.close();
    }

}
