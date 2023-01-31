package model;

import java.time.LocalDate;


public abstract class Device {
    private int deviceId;
    private LocalDate devicePurchaseDate;
    private String deviceBrand;
    private String deviceModel;
    private float deviceSerialNumber;
    private int deviceAmortizationTime;
    private boolean deviceInUse;

    /**
     * The constructor. Klasa abstrakcyjna - sprzęt
     * @param deviceId Id sprzętu
     * @param devicePurchaseDate Data zakupu sprzętu
     * @param deviceBrand Marka
     * @param deviceModel Model
     * @param deviceSerialNumber Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse Czy sprzęt jest w użyciu
     */
    public Device(int deviceId,
                  LocalDate devicePurchaseDate,
                  String deviceBrand,
                  String deviceModel,
                  float deviceSerialNumber,
                  int deviceAmortizationTime,
                  boolean deviceInUse) {
        this.deviceId = deviceId;
        this.devicePurchaseDate = devicePurchaseDate;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceSerialNumber = deviceSerialNumber;
        this.deviceAmortizationTime = deviceAmortizationTime;
        this.deviceInUse = deviceInUse;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public LocalDate getDevicePurchaseDate() {
        return devicePurchaseDate;
    }

    public String getDeviceBrand() {
        return deviceBrand;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public float getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public int getDeviceAmortizationTime() {
        return deviceAmortizationTime;
    }

    public boolean isDeviceInUse() {
        return deviceInUse;
    }

    public void retireDevice(){
        deviceInUse = false;
    }

    public void enableDevice(){
        deviceInUse = true;
    }
}
