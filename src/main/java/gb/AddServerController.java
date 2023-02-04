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

public class AddServerController implements Initializable{
    @FXML private Button serverSaveForm;
    @FXML private Button serverExitForm;
    @FXML private TableView<Server> serverTableView;

    // Device fields:
    @FXML private int deviceId;
    @FXML private LocalDate devicePurchaseDate;
    @FXML private String deviceBrand;
    @FXML private String deviceModel;
    @FXML private float deviceSerialNumber;
    @FXML private int deviceAmortizationTime;
    @FXML private boolean deviceInUse;

    // Server fields

    @FXML
    private DatePicker serverPurchaseDate;

/*    @FXML
    public void initialize() throws Exception{

    }*/



    @FXML
    private void validateForm(ActionEvent event) {
        System.out.println(serverPurchaseDate.getValue());
        addNewServer(event);
    }

    @FXML
    private void closeFormAction() {
        Stage stage = (Stage) serverPurchaseDate.getScene().getWindow();
        stage.close();
    }

    @FXML
    protected void addNewServer(ActionEvent event) {
        ObservableList<Server> servers;
//        servers.add(new Server())
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
