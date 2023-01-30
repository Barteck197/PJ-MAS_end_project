package model;

import java.time.LocalDate;

public abstract class ServerDevice extends Device{
    private LocalDate serverDeviceMountDate;
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
     */
    public ServerDevice(int deviceId,
                        LocalDate devicePurchaseDate,
                        String deviceBrand,
                        String deviceModel,
                        float deviceSerialNumber,
                        int deviceAmortizationTime,
                        boolean deviceInUse,
                        LocalDate serverDeviceMountDate) {
        super(deviceId, devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse);
        this.serverDeviceMountDate = serverDeviceMountDate;
    }

    public LocalDate getServerDeviceMountDate() {
        return serverDeviceMountDate;
    }

    public void setServerDeviceMountDate(LocalDate serverDeviceMountDate) {
        this.serverDeviceMountDate = serverDeviceMountDate;
    }
}
