package gb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Rack;
import model.Server;

import java.util.ArrayList;
import java.util.List;

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

    private Server selectedServer = null;
    @FXML
    private Button discardChanges;

    ObservableList<Server> rackServersObservableList;

    public RackController(Rack viewRack) {
        this.viewRack = viewRack;
    }

    public RackController() {
    }

    @FXML
    public void initialize() throws ClassNotFoundException {
        if (viewRack != null) {
            setViewRack(viewRack);

            rackServersObservableList = FXCollections.
                    observableArrayList(viewRack.getServers());
            rackServers.setItems(rackServersObservableList);
//            System.out.println(rackServers.getItems());

            rackServers.setOnMouseClicked(mouseEvent -> {
                if (mouseEvent.getClickCount() == 2) {
                    try {
                        showRackServer(rackServers.getSelectionModel().getSelectedItem());
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
                selectedServer = rackServers.getSelectionModel().getSelectedItem();
            });
        }
//        System.out.println(ObjectPlus.getExtent(Server.class));
    }

    /**
     * Wypełnienie formularza danymi dotyczącymi wybranej szafy rack
     *
     * @param rack Szafa rack
     */
    public void setViewRack(Rack rack) {
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

    /**
     * Utworzenie nowej szafy rack na podstawie parametrów podanych w formularzu.
     */
    public void createNewRack() {
        try {
            new Rack(
                    devicePurchaseDate.getValue(),
                    deviceBrand.getText(),
                    deviceModel.getText(),
                    Long.parseLong(deviceSerialNumber.getText()),
                    Integer.parseInt(deviceAmortizationTime.getText()),
                    deviceInUse.isSelected(),
                    deviceInstalationTime.getValue(),
                    Integer.parseInt(rackHeight.getText()),
                    Integer.parseInt(rackWidth.getText()),
                    Integer.parseInt(rackDepth.getText()),
                    Integer.parseInt(rackVolume.getText())
            );
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Niepoprawne dane.");
            alert.setContentText(ex.getMessage());
            alert.show();
        }
    }

    /**
     * Zapisanie danych dt. szafy.
     * Obsługujemy scenariusz dodania nowej jak i aktualizacji.
     */
    @FXML
    protected void saveRackData() {
        if (viewRack == null) {
            // Jeśli byliśmy w trybie dodawania szafy - tworzymy nowy obiekt
            createNewRack();
        } else {
            // W przeciwnym razie aktualizujemy informacje o szafie
            updateRackData();
        }

        closeFormAction();
    }

    /**
     * Aktualizowanie danych dt szafy. Dane sczytujemy z formularza.
     */
    public void updateRackData() {
        try {
            viewRack.setDevicePurchaseDate(devicePurchaseDate.getValue());
            viewRack.setDeviceBrand(deviceBrand.getText());
            viewRack.setDeviceModel(deviceModel.getText());
            viewRack.setDeviceAmortizationTime(Integer.parseInt(deviceAmortizationTime.getText()));
            viewRack.setDeviceInUse(deviceInUse.isSelected());
            viewRack.setServerDeviceMountDate(deviceInstalationTime.getValue());
            viewRack.setRackHeight(Integer.parseInt(rackHeight.getText()));
            viewRack.setRackWidth(Integer.parseInt(rackWidth.getText()));
            viewRack.setRackLength(Integer.parseInt(rackDepth.getText()));
            viewRack.setRackVolume(Integer.parseInt(rackVolume.getText()));
        } catch (Exception ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Niepoprawne dane.");
            alert.setContentText(ex.getMessage());
            alert.show();
        }

        // Usunięcie obiektów
        List<Server> linkedServers = rackServers.getItems();
        for (Server srv : new ArrayList<>(viewRack.getServers())) {
            if (!linkedServers.contains(srv)) {
                viewRack.removeServer(srv);
            }
        }

        // Dodanie powiązań
        for (Server srv : linkedServers) {
            try {
                viewRack.addServerToRack(srv);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Metoda obsługująca dodawanie nowego serwera z poziomu widoku szafy
     */
    @FXML
    protected void addRackServer() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("server-view.fxml"));
            loader.setControllerFactory(controller -> new ServerController(viewRack));
            // Load the FXML file
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root, 680, 480));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Otwarcie nowego okna z widokiem szczegółów serwera wybranego z tabelki.
     *
     * @param server instancja obiektu serwer.
     */
    @FXML
    protected void showRackServer(Server server) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("server-view.fxml"));
            loader.setControllerFactory(controller -> new ServerController(server, viewRack));
            // Load the FXML file
            Parent root = loader.load();

            // Create a new stage
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Usunięcie serwera z poziomu widoku szafy. Usuwamy serwer aktualnie zaznaczony
     */
    @FXML
    protected void deleteRackServer() {
        // Tworzymy tymczasową 'observable list'
//        ObservableList<Server> rackServersObservableList = FXCollections.observableArrayList(rackServers.getItems());
        // Usuwamy żądany obiekt z listy
        rackServersObservableList.remove(selectedServer);
        // Przypisujemy do widoku zaktualizowaną listę
        rackServers.setItems(rackServersObservableList);
    }

    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) discardChanges.getScene().getWindow();
        stage.close();
    }

}
