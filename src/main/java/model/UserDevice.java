package model;

import java.time.LocalDate;

public abstract class UserDevice extends Device {
    private Site workerDeviceLocation;
    private LocalDate workerDeviceIssueDate;
    private Worker workerDeviceOwner;

    /**
     * Konstruktor klasy Sprzęt pracownika
     *
     * @param devicePurchaseDate     Data zakupu sprzętu
     * @param deviceBrand            Marka
     * @param deviceModel            Model
     * @param deviceSerialNumber     Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse            Czy sprzęt jest w użyciu
     */
    public UserDevice(LocalDate devicePurchaseDate,
                      String deviceBrand,
                      String deviceModel,
                      long deviceSerialNumber,
                      int deviceAmortizationTime,
                      boolean deviceInUse,
                      Site workerDeviceLocation,
                      LocalDate workerDeviceIssueDate) {
        super(devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse);
        this.workerDeviceLocation = workerDeviceLocation;
        this.workerDeviceIssueDate = workerDeviceIssueDate;
    }

    /**
     * Getters and setters for subclass attributes
     */
    public Site getWorkerDeviceLocation() {
        return workerDeviceLocation;
    }

    public void setWorkerDeviceLocation(Site workerDeviceLocation) {
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
     * @param newWorkerDeviceWorker obiekt klasy pracownik4
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

    /**
     * Usunięcie pracownika przypisanego do sprzętu
     */
    public void removeUserDeviceOwner() {
        workerDeviceOwner.removeWorkerDevice(this);
        workerDeviceOwner = null;
    }
}
