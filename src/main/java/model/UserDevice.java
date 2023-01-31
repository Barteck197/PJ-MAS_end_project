package model;

import java.time.LocalDate;

public abstract class UserDevice extends Device {
    private site workerDeviceLocation;
    private LocalDate workerDeviceIssueDate;
    private Worker workerDeviceOwner;

    /**
     * Konstruktor klasy Sprzęt pracownika
     *
     * @param deviceId               Id sprzętu
     * @param devicePurchaseDate     Data zakupu sprzętu
     * @param deviceBrand            Marka
     * @param deviceModel            Model
     * @param deviceSerialNumber     Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse            Czy sprzęt jest w użyciu
     */
    public UserDevice(int deviceId,
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

    /**
     * Znajdowanie pracownika przypisanego do sprzętu
     *
     * @return obiekt klasy pracownik
     */
    public Worker getWorkerDeviceOwner() {
        return workerDeviceOwner;
    }

    /**
     * Przypisanie pracownika do sprzętu
     *
     * @param workerDeviceWorker obiekt klasy pracownik4
     */
    public void setWorkerDeviceOwner(Worker newWorkerDeviceWorker) {
        // Jeśli sprzęt pracownika ma właściciela...
        if (workerDeviceOwner != null) {
            // ... i jest to inna osoba niż nowy właścicel ...
            if (workerDeviceOwner != newWorkerDeviceWorker) {
                // ... to usuwamy połączenie
                workerDeviceOwner.removeWorkerDevice(this);
            }
        }
        // Tworzymy (nowe) połączenie
        workerDeviceOwner = newWorkerDeviceWorker;
        workerDeviceOwner.addWorkerDevice(this);
    }

    public void removeWorkerDeviceOwner() {
        workerDeviceOwner = null;
    }
}
