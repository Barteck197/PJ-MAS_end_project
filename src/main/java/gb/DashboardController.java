package gb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Server;
import utils.ObjectPlus;

import java.util.ArrayList;

public class DashboardController {

    @FXML
    private TableView<Server> serverTableView = new TableView<>();

    private Server selectedServer;

    @FXML
    public void initialize() throws Exception {
        ArrayList<Server> servers = (ArrayList<Server>) ObjectPlus.getExtent(Server.class);
        ObservableList<Server> serverObservableList = FXCollections.observableArrayList(servers);
        serverTableView.setItems(serverObservableList);

        serverTableView.setOnMouseClicked(mouseEvent -> {
            selectedServer = serverTableView.getSelectionModel().getSelectedItem();
            if (mouseEvent.getClickCount() == 2) {
                try {
                    showServer(selectedServer);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    @FXML
    protected void showServer(Server server) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("server-view.fxml"));
        // Podczas ładowania nowego okna w konstruktorze przekazujemy obiekt serwera do wyświetlenia
        loader.setControllerFactory(controller -> new ServerController(server, server.getServerRack()));
        Pane myPane = loader.load();

        Stage newStage = new Stage();
        newStage.setScene(new Scene(myPane));
        newStage.show();
    }

    @FXML
    void viewRackList() {
        try {
            Parent nextView = FXMLLoader.load(getClass().getResource("rack-list-view.fxml"));
            Scene nextScene = new Scene(nextView);

            Stage currentStage = (Stage) serverTableView.getScene().getWindow();
            currentStage.setScene(nextScene);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void deleteServer() {
        // Tworzymy tymczasową 'observable list'
        ObservableList<Server> serversObservableList = FXCollections.observableArrayList(serverTableView.getItems());
        // Usuwamy żądany obiekt z listy
        serversObservableList.remove(selectedServer);
        // Przypisujemy do widoku zaktualizowaną listę
        serverTableView.setItems(serversObservableList);
    }
}
