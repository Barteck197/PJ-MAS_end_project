package model;

import utils.ObjectPlus;

import java.time.LocalDate;


public abstract class Device extends ObjectPlus {
    private static int nextDeviceID = 0;

    private int deviceId;
    private LocalDate devicePurchaseDate;
    private String deviceBrand;
    private String deviceModel;
    private long deviceSerialNumber;
    private int deviceAmortizationTime;
    private boolean deviceInUse;

    private PurchaseOrder devicePurchaseOrder;

    /**
     * The constructor. Klasa abstrakcyjna - sprzęt
     *
     * @param devicePurchaseDate     Data zakupu sprzętu
     * @param deviceBrand            Marka
     * @param deviceModel            Model
     * @param deviceSerialNumber     Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse            Czy sprzęt jest w użyciu
     */
    public Device(LocalDate devicePurchaseDate,
                  String deviceBrand,
                  String deviceModel,
                  long deviceSerialNumber,
                  int deviceAmortizationTime,
                  boolean deviceInUse) {
        super();
        this.deviceId = nextDeviceID++;
        this.devicePurchaseDate = devicePurchaseDate;
        this.deviceBrand = deviceBrand;
        this.deviceModel = deviceModel;
        this.deviceSerialNumber = deviceSerialNumber;
        this.deviceAmortizationTime = deviceAmortizationTime;
        this.deviceInUse = deviceInUse;
    }

    /**
     * Dodawanie zamówienia do obiekru Sprzęt
     *
     * @param newPO nowe zamówienie
     */
    public void addPurchaseOrder(PurchaseOrder newPO) {
        if (devicePurchaseOrder == null) {
            devicePurchaseOrder = newPO;
            newPO.addDevice(this);
        }
    }

    /**
     * Usuwanie zamówienia z obiektu sprzet
     */
    public void removePurchaseOrder(PurchaseOrder oldPO) {
        if (devicePurchaseOrder != null) {
            devicePurchaseOrder = null;
            oldPO.removeDevice(this);
        }
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

    public long getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public int getDeviceAmortizationTime() {
        return deviceAmortizationTime;
    }

    public boolean isDeviceInUse() {
        return deviceInUse;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public void setDevicePurchaseDate(LocalDate devicePurchaseDate) {
        this.devicePurchaseDate = devicePurchaseDate;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public void setDeviceSerialNumber(long deviceSerialNumber) {
        this.deviceSerialNumber = deviceSerialNumber;
    }

    public void setDeviceAmortizationTime(int deviceAmortizationTime) {
        this.deviceAmortizationTime = deviceAmortizationTime;
    }

    public void setDeviceInUse(boolean deviceInUse) {
        this.deviceInUse = deviceInUse;
    }

    public void setDevicePurchaseOrder(PurchaseOrder devicePurchaseOrder) {
        this.devicePurchaseOrder = devicePurchaseOrder;
    }

    public void retireDevice() {
        deviceInUse = false;
    }

    public void enableDevice() {
        deviceInUse = true;
    }
}
