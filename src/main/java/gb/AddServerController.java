package gb;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
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
    @FXML private TextField deviceBrand;
    @FXML private TextField deviceModel;
    @FXML private TextField deviceSerialNumber;
    @FXML private TextField deviceAmortizationTime;
    @FXML private RadioButton deviceInUse;

    @FXML private DatePicker deviceInstalationTime;

    // Server fields
    @FXML private TextField serverMountedDisks;
    @FXML private TextField serverMaxRAMMemory;
    @FXML private Rack serverRack;
    @FXML private TextField serverPositionInRack;
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
