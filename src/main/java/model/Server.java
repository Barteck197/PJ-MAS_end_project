package model;

import java.time.LocalDate;

public class Server extends ServerDevice{
    private int serverMountedDisks;
    private final int serverMaxRAMMemory;

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
    public Server(int deviceId, LocalDate devicePurchaseDate, String deviceBrand, String deviceModel,
                  float deviceSerialNumber, int deviceAmortizationTime, boolean deviceInUse,
                  LocalDate serverDeviceMountDate, int serverMountedDisks, int serverMaxRAMMemory) {
        super(deviceId, devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse, serverDeviceMountDate);
        this.serverMountedDisks = serverMountedDisks;
        this.serverMaxRAMMemory = serverMaxRAMMemory;
    }
}
