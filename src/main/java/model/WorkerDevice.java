package model;

import java.time.LocalDate;

public abstract class WorkerDevice extends Device {
    private site workerDeviceLocation;
    private LocalDate workerDeviceIssueDate;

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
    public WorkerDevice(int deviceId,
                        LocalDate devicePurchaseDate,
                        String deviceBrand,
                        String deviceModel,
                        float deviceSerialNumber,
                        int deviceAmortizationTime,
                        boolean deviceInUse,
                        site workerDeviceLocation,
                        LocalDate workerDeviceIssueDate) {
        super(deviceId, devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse);
        this.workerDeviceLocation = workerDeviceLocation;
        this.workerDeviceIssueDate = workerDeviceIssueDate;
    }

    /**
     * Getters and setters for subclass attributes
     */
    public site getWorkerDeviceLocation() {
        return workerDeviceLocation;
    }

    public void setWorkerDeviceLocation(site workerDeviceLocation) {
        this.workerDeviceLocation = workerDeviceLocation;
    }

    public LocalDate getWorkerDeviceIssueDate() {
        return workerDeviceIssueDate;
    }

    public void setWorkerDeviceIssueDate(LocalDate workerDeviceIssueDate) {
        this.workerDeviceIssueDate = workerDeviceIssueDate;
    }
}
