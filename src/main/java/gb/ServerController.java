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
    private Label serverRack = new Label();
    @FXML
    private Label serverPositionInRack = new Label();

    /**
     * Kontroler uruchamiany przy podglądzie serwera z poziomu szafy rack
     * @param viewServer serwer, który chcemy oglądać
     * @param viewRack szafa do której jest przypisany
     */
    public ServerController(Server viewServer, Rack viewRack) {
        this.viewServer = viewServer;
        this.viewRack = viewRack;

        serverRack.setText(viewRack.getDeviceBrand() + " " + viewRack.getDeviceModel());
        serverPositionInRack.setText(String.valueOf(viewServer.getServerPositionInRack()));
    }

    /**
     * Kontroler uruchamiany przy dodawaniu nowego serwera
     * @param viewRack szafa w której ma być dodany serwer
     */
    public ServerController(Rack viewRack) {
        this.viewRack = viewRack;

        serverRack.setText(viewRack.getDeviceBrand() + " " + viewRack.getDeviceModel());
        serverPositionInRack = new Label();
    }

//    public ServerController(Server server){ this.viewServer = server;}

    @FXML
    public void initialize() {
        if (viewServer != null) {
            setServer(viewServer);
        }
    }

    @FXML
    protected void setServer(Server server) {
        devicePurchaseDate.setValue(server.getDevicePurchaseDate());
        deviceBrand.setText(server.getDeviceBrand());
        deviceModel.setText(server.getDeviceModel());
        deviceSerialNumber.setText(String.valueOf(server.getDeviceSerialNumber()));
        deviceAmortizationTime.setText(String.valueOf(server.getDeviceAmortizationTime()));
        deviceInUse.setSelected(server.isDeviceInUse());
        deviceInstalationTime.setValue(server.getServerDeviceMountDate());

        serverMountedDisks.setText(String.valueOf(server.getServerMountedDisks()));
        serverMaxRAMMemory.setText(String.valueOf(server.getServerMaxRAMMemory()));
        serverRack.setText(server.getServerRack().getDeviceBrand() + " " + server.getServerRack().getDeviceModel());
        serverPositionInRack.setText(String.valueOf(server.getServerPositionInRack()));
    }

    @FXML
    protected void createNewServer() {
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

    @FXML
    protected void saveServerData() {
        if (viewServer == null) {
            createNewServer();
        } else {
            updateServerData();
        }
        closeFormAction();
    }

    protected void updateServerData() {
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
    protected void closeFormAction() {
        Stage stage = (Stage) devicePurchaseDate.getScene().getWindow();
        stage.close();
    }

}
