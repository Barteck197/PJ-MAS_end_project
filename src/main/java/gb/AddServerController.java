package gb;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.Computer;
import model.Rack;
import model.Server;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class AddServerController {
    @FXML private Button serverSaveForm;
    @FXML private Button serverExitForm;

    // Device fields
    @FXML private DatePicker devicePurchaseDate;
    @FXML private String deviceBrand;
    @FXML private String deviceModel;
    @FXML private float deviceSerialNumber;
    @FXML private int deviceAmortizationTime;
    @FXML private boolean deviceInUse;

    @FXML private LocalDate deviceInstalationTime;

    // Server fields
    @FXML private int serverMountedDisks;
    @FXML private int serverMaxRAMMemory;
    @FXML private Rack serverRack;
    @FXML private int serverPositionInRack;
    @FXML private Computer serverComputer;


/*    @FXML
    public void initialize() throws Exception{

    }*/



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
