package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Server extends ServerDevice {
    private int serverMountedDisks;
    private final int serverMaxRAMMemory;
    private Rack serverRack;
    private int serverPositionInRack;

    // Atrybuty pod asocjację (z atrybutem)
    private List<VirtualMachine> serverVirtualMachine;
    private static Set<VirtualMachine> allVirtualMachines;

    /**
     * The constructor. Private. There's no Server without RACK.
     *
     * @param deviceId               Id sprzętu
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
    private Server(int deviceId, LocalDate devicePurchaseDate, String deviceBrand, String deviceModel,
                   float deviceSerialNumber, int deviceAmortizationTime, boolean deviceInUse,
                   LocalDate serverDeviceMountDate, int serverMountedDisks, int serverMaxRAMMemory, Rack serverRack, int serverPositionInRack) {
        super(deviceId, devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse, serverDeviceMountDate);
        this.serverMountedDisks = serverMountedDisks;
        this.serverMaxRAMMemory = serverMaxRAMMemory;
        this.serverRack = serverRack;
        this.serverPositionInRack = serverPositionInRack;
        this.serverVirtualMachine = new ArrayList<>();
    }

    /**
     * Method for creating new Server object
     *
     * @param deviceId
     * @param devicePurchaseDate
     * @param deviceBrand
     * @param deviceModel
     * @param deviceSerialNumber
     * @param deviceAmortizationTime
     * @param deviceInUse
     * @param serverDeviceMountDate
     * @param serverMountedDisks
     * @param serverMaxRAMMemory
     * @param serverRack
     * @param serverPositionInRack
     * @return new Server Object
     * @throws Exception
     */
    public static Server CreateServer(int deviceId, LocalDate devicePurchaseDate, String deviceBrand, String deviceModel,
                                      float deviceSerialNumber, int deviceAmortizationTime, boolean deviceInUse,
                                      LocalDate serverDeviceMountDate, int serverMountedDisks, int serverMaxRAMMemory,
                                      Rack serverRack, int serverPositionInRack) throws Exception {
        if (serverRack == null) {
            throw new Exception("Dana szafa nie istnieje");
        }

        // Utworzenie części
        Server srv = new Server(deviceId, devicePurchaseDate, deviceBrand, deviceModel,
                deviceSerialNumber, deviceAmortizationTime, deviceInUse, serverDeviceMountDate,
                serverMountedDisks, serverMaxRAMMemory, serverRack, serverPositionInRack);

        serverRack.addServerToRack(srv);

        return srv;
    }

    public void addVMToServer(VirtualMachine newVM) throws Exception {
        if (!serverVirtualMachine.contains(newVM)){
            // Jeśli podana wirtualka nie jest już przypisana do jakiegoś serwera...
            if(!allVirtualMachines.contains(newVM)){
                throw new Exception("Ta wirtualka jest już przypisana do szafy");
            }
            serverVirtualMachine.add(newVM);
            allVirtualMachines.add(newVM);

        }
    }

    public int getServerPositionInRack() {
        return serverPositionInRack;
    }
}
