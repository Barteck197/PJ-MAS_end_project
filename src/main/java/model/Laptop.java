package model;

import java.time.LocalDate;

public class Laptop extends UserDevice{
    private float laptopScreenSize;     // Przekątna ekranu wyrażona w calach

    /**
     * Kontruktor do tworzenia obiektów typu laptop
     * @param deviceId
     * @param devicePurchaseDate
     * @param deviceBrand
     * @param deviceModel
     * @param deviceSerialNumber
     * @param deviceAmortizationTime
     * @param deviceInUse
     * @param workerDeviceLocation
     * @param workerDeviceIssueDate
     * @param laptopScreenSize
     */
    public Laptop(int deviceId, LocalDate devicePurchaseDate, String deviceBrand,
                  String deviceModel, float deviceSerialNumber, int deviceAmortizationTime,
                  boolean deviceInUse, Site workerDeviceLocation, LocalDate workerDeviceIssueDate,
                  float laptopScreenSize) {
        super(deviceId, devicePurchaseDate, deviceBrand, deviceModel,
                deviceSerialNumber, deviceAmortizationTime, deviceInUse,
                workerDeviceLocation, workerDeviceIssueDate);
        this.laptopScreenSize = laptopScreenSize;
    }
}
