package model;

import java.time.LocalDate;

public class Screen extends UserDevice{
    private float screenSize;

    /**
     * Konstruktor do tworzenia obiektów typu Ekran
     * @param deviceId
     * @param devicePurchaseDate
     * @param deviceBrand
     * @param deviceModel
     * @param deviceSerialNumber
     * @param deviceAmortizationTime
     * @param deviceInUse
     * @param workerDeviceLocation
     * @param workerDeviceIssueDate
     * @param screenSize
     */
    public Screen(int deviceId, LocalDate devicePurchaseDate, String deviceBrand, String deviceModel,
                  float deviceSerialNumber, int deviceAmortizationTime, boolean deviceInUse,
                  Site workerDeviceLocation, LocalDate workerDeviceIssueDate, float screenSize) {
        super(deviceId, devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse, workerDeviceLocation, workerDeviceIssueDate);
        this.screenSize = screenSize;
    }
}
