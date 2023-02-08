package gb;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.Computer;
import model.Rack;
import model.Server;
import utils.ObjectPlus;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main extends Application {
    public static Server server;
    public static List<Server> serverList = new ArrayList<>();
    public static List<Rack> rackList = new ArrayList<>();
    public static List<Computer> computerList = new ArrayList<>();

    public final static String pathToData = "data/data.bin";

    @Override
    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 960, 640);
        stage.setTitle("Inventory Manager");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                Platform.exit();
                try {
                    // Zapisanie ekstensji do pliku
                    saveExtent();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        try {
            // Wczytywanie ekstensji klas z pliku
            readExtent();
            launch();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metoda wczytująca dane dt. ekstensji z pliku
     *
     * @throws Exception
     */
    public static void readExtent() throws Exception {
        File serializedDataFile = new File(pathToData);

        if (serializedDataFile.exists() && serializedDataFile.length() != 0) {
            System.out.println("Reading Extent...");
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(serializedDataFile));
            ObjectPlus.readExtents(oin);
            oin.close();

            serverList.addAll((Collection<? extends Server>) ObjectPlus.getExtent(Server.class));
            rackList.addAll((Collection<? extends Rack>) ObjectPlus.getExtent(Rack.class));
            computerList.addAll((Collection<? extends Computer>) ObjectPlus.getExtent(Computer.class));
        } else {
            System.out.println("No file. Creating sample data...");
            Computer computer = new Computer(2.4, 16, 256, "Windows 11");

            Rack rack = new Rack(LocalDate.of(2022, 11, 26), "Enoc System", "NS6618", 613414, 2, true,
                    LocalDate.of(2022, 12, 01), 187, 60, 60, 19);

            Server server = Server.CreateServer(LocalDate.of(2023, 01, 20), "Dell", "PowerEdge R250", 32450, 2, true,
                    LocalDate.of(2023, 02, 01), 4, 64, rack, 1);

            Server server1 = Server.CreateServer(LocalDate.of(2023, 02, 07), "Cisco", "UCS C240 M6", 2554, 5, true,
                    LocalDate.of(2023, 02, 07), 4, 16, rack, 2);

            serverList.add(server);
            serverList.add(server1);
            rackList.add(rack);
            computerList.add(computer);
        }
    }

    /**
     * Metoda zapisująca dane dt. ekstensji w pliku
     *
     * @throws Exception
     */
    public static void saveExtent() throws Exception {
        System.out.println("Saving extent...");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathToData));
        ObjectPlus.writeExtents(oos);
        oos.close();
    }
}