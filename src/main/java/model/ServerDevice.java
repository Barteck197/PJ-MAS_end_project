package model;

import java.time.LocalDate;

public abstract class ServerDevice extends Device {
    private LocalDate serverDeviceMountDate;

    /**
     * The constructor. Klasa Sprzęt serwerowni
     *
     * @param devicePurchaseDate     Data zakupu sprzętu
     * @param deviceBrand            Marka
     * @param deviceModel            Model
     * @param deviceSerialNumber     Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse            Czy sprzęt jest w użyciu
     * @param serverDeviceMountDate  Data montażu sprzętu
     */
    public ServerDevice(LocalDate devicePurchaseDate,
                        String deviceBrand,
                        String deviceModel,
                        long deviceSerialNumber,
                        int deviceAmortizationTime,
                        boolean deviceInUse,
                        LocalDate serverDeviceMountDate) {
        super(devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse);
        this.serverDeviceMountDate = serverDeviceMountDate;
    }

    public LocalDate getServerDeviceMountDate() {
        return serverDeviceMountDate;
    }

    public void setServerDeviceMountDate(LocalDate serverDeviceMountDate) {
        this.serverDeviceMountDate = serverDeviceMountDate;
    }
}
