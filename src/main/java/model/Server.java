package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Server extends ServerDevice {
    private int serverMountedDisks;
    private final int serverMaxRAMMemory;
    private Rack serverRack;
    private int serverPositionInRack;
    private Computer serverComputer;

    // Atrybuty pod asocjację (z atrybutem)
    private List<VirtualMachine> serverVirtualMachines;
    private static Set<VirtualMachine> allVirtualMachines;

    /**
     * The constructor. Private. There's no Server without RACK.
     *
     * @param devicePurchaseDate     Data zakupu sprzętu
     * @param deviceBrand            Marka
     * @param deviceModel            Model
     * @param deviceSerialNumber     Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse            Czy sprzęt jest w użyciu
     * @param serverDeviceMountDate  Data instalacji serwera w serwerowni
     * @param serverMaxRAMMemory     Maksymalna ilość pamięci RAM
     * @param serverMountedDisks     Liczba zamontowanych dysków twardych
     */
    private Server(LocalDate devicePurchaseDate, String deviceBrand, String deviceModel,
                   long deviceSerialNumber, int deviceAmortizationTime, boolean deviceInUse,
                   LocalDate serverDeviceMountDate, int serverMountedDisks, int serverMaxRAMMemory, Rack serverRack, int serverPositionInRack) {
        super(devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse, serverDeviceMountDate);
        this.serverMountedDisks = serverMountedDisks;
        this.serverMaxRAMMemory = serverMaxRAMMemory;
        this.serverRack = serverRack;
        this.serverPositionInRack = serverPositionInRack;

        this.serverVirtualMachines = new ArrayList<>();
    }

    /**
     * Metoda tworząca serwer, kompozycja w klasie szafa rack oraz w klasie komputer.
     *
     * @return new Server Object
     * @throws Exception
     */
    public static Server CreateServer(LocalDate devicePurchaseDate, String deviceBrand, String deviceModel,
                                      long deviceSerialNumber, int deviceAmortizationTime, boolean deviceInUse,
                                      LocalDate serverDeviceMountDate, int serverMountedDisks, int serverMaxRAMMemory,
                                      Rack serverRack, int serverPositionInRack) throws Exception {
        if (serverRack == null) {
            throw new Exception("Dana szafa nie istnieje");
        }

        // Utworzenie serwera
        Server srv = new Server(devicePurchaseDate, deviceBrand, deviceModel,
                deviceSerialNumber, deviceAmortizationTime, deviceInUse, serverDeviceMountDate,
                serverMountedDisks, serverMaxRAMMemory, serverRack, serverPositionInRack);

        // Umieszczenie serwera w szafie rack
        serverRack.addServerToRack(srv);

        return srv;
    }

    /**
     * Obsługiwanie dodawania maszyny wirtualnej do serwera
     *
     * @param newVM instancja obiektu maszyny wirtualnej
     * @throws Exception wyjątek jeśli nie można dodać wirtualki
     */
    public void addVMToServer(VirtualMachine newVM) throws Exception {
        // Jeśli podana maszyna wirtualna nie jest zainstalowana w tym serwerze.
        if (!serverVirtualMachines.contains(newVM)) {
            // Jeśli podana wirtualka nie jest już przypisana do jakiegoś serwera...
            if (!allVirtualMachines.contains(newVM)) {
                throw new Exception("Ta wirtualka jest już przypisana do szafy");
            }
            serverVirtualMachines.add(newVM);
            allVirtualMachines.add(newVM);

        }
    }

    /**
     * Sprawdzamy gdzie w szafie jest zamontowany serwer
     *
     * @return miejsce montażu w szafie
     */
    public int getServerPositionInRack() {
        return serverPositionInRack;
    }

    public int getServerMountedDisks() {
        return serverMountedDisks;
    }

    public void setServerMountedDisks(int serverMountedDisks) {
        this.serverMountedDisks = serverMountedDisks;
    }

    public int getServerMaxRAMMemory() {
        return serverMaxRAMMemory;
    }

    public Rack getServerRack() {
        return serverRack;
    }

    public void setServerRack(Rack serverRack) {
        this.serverRack = serverRack;
    }

    public void setServerPositionInRack(int serverPositionInRack) {
        this.serverPositionInRack = serverPositionInRack;
    }

    public Computer getServerComputer() {
        return serverComputer;
    }

    public void setServerComputer(Computer serverComputer) {
        this.serverComputer = serverComputer;
    }

    @Override
    public String toString() {
        return getDeviceBrand() + " " + getDeviceModel();
    }
}
