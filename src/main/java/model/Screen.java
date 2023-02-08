package model;

import java.time.LocalDate;

public class Screen extends UserDevice{
    private float screenSize;

    /**
     * Konstruktor do tworzenia obiektów typu Ekran
     */
    public Screen(LocalDate devicePurchaseDate, String deviceBrand, String deviceModel,
                  long deviceSerialNumber, int deviceAmortizationTime, boolean deviceInUse,
                  Site workerDeviceLocation, LocalDate workerDeviceIssueDate, float screenSize) {
        super(devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse, workerDeviceLocation, workerDeviceIssueDate);
        this.screenSize = screenSize;
    }
}
