package model;

import java.time.LocalDate;

public class Server extends ServerDevice {
    private int serverMountedDisks;
    private final int serverMaxRAMMemory;
    private Rack serverRack;
    private int serverPositionInRack;

    /**
     * The constructor
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
    }

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

    public int getServerPositionInRack() {
        return serverPositionInRack;
    }
}
