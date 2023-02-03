package gb;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import model.Computer;
import model.Rack;
import model.Server;

import java.time.LocalDate;

public class AddServerController {
    @FXML
    private Button serverSaveForm;

    @FXML
    private Button serverExitForm;

    // Device fields:
    private int deviceId;
    private LocalDate devicePurchaseDate;
    private String deviceBrand;
    private String deviceModel;
    private float deviceSerialNumber;
    private int deviceAmortizationTime;
    private boolean deviceInUse;

    @FXML
    private DatePicker serverPurchaseDate;



    public AddServerController() throws Exception {
    }


    @FXML
    private void validateForm(ActionEvent event){
        System.out.println(serverPurchaseDate.getValue());
    }

    @FXML
    private void closeFormAction(){
        Stage stage = (Stage) serverPurchaseDate.getScene().getWindow();
        stage.close();
    }

    protected void addNewServer(){

    }


//    Server srv1 = Server.CreateServer(12,
//            LocalDate.now(),
//            "Dell",
//            "e5410",
//            12341324,
//            2,
//            true,
//            LocalDate.now(),
//            1,
//            64,
//            new Rack(13,
//                    LocalDate.now(),
//                    "Rack",
//                    "e1",
//                    123,
//                    3,
//                    true,
//                    LocalDate.now(),
//                    10, 10, 10,3
//                    ),
//            1,
//            new Computer(2.4, 8,256,"windows 10"));

}
