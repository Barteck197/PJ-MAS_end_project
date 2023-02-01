package model;

import model.oplus.ObjectPlus;

import java.util.ArrayList;
import java.util.List;

public class Worker extends ObjectPlus {
    // Class attributes
    private int workerId;
    private static int workerNumbers = 0;
    private String workerName;
    private String workerLastName;
    private boolean workerIndefiniteContract;
    private String workerPosition;

    // Associations
    private List<UserDevice> userDevices;

    /**
     * Konstruktor klasy pracownik
     *
     * @param workerName     Imię
     * @param workerLastName Nazwisko
     * @param workerContract Czy ma umowę na czas nieokreślony
     * @param workerPosition Stanowisko w firmie
     * @param userDevice   Sprzęt pracownika
     */
    public Worker(String workerName, String workerLastName, boolean workerContract, String workerPosition, UserDevice userDevice) {
        workerId = ++workerNumbers;
        this.workerName = workerName;
        this.workerLastName = workerLastName;
        this.workerIndefiniteContract = workerContract;
        this.workerPosition = workerPosition;

        // Każdy pracownik musi mieć przynajmniej jeden sprzęt
        // Dlatego przypisujemy sprzęt pracownikowi w konstruktorze
        userDevices = new ArrayList<>();
        userDevices.add(userDevice);
    }

    /**
     * Dodawanie sprzętu pracownika do listy jego sprzętu.
     *
     * @param newDevice nowy sprzęt do dodania
     */
    public void addWorkerDevice(UserDevice newDevice) {
        if (!userDevices.contains(newDevice)) {
            userDevices.add(newDevice);

            newDevice.setWorkerDeviceOwner(this);
        }
    }

    /**
     * Usuwanie sprzętu przypisanego do pracownika
     *
     * @param oldDevice stary sprzęt
     */
    public void removeWorkerDevice(UserDevice oldDevice) {
        userDevices.remove(oldDevice);
        oldDevice.removeUserDeviceOwner();
    }

    public int getWorkerId() {
        return workerId;
    }

    public static int getWorkerNumbers() {
        return workerNumbers;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String getWorkerLastName() {
        return workerLastName;
    }

    public String getWorkerPosition() {
        return workerPosition;
    }

    public List<UserDevice> getWorkerDevices() {
        return userDevices;
    }

    public boolean hasIndefiniteContract() {
        return workerIndefiniteContract;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public void setWorkerLastName(String workerLastName) {
        this.workerLastName = workerLastName;
    }

    public void promoteWorker(String newWorkerPosition) {
        this.workerPosition = newWorkerPosition;
    }

    public void setWorkerIndefiniteContract(boolean indefiniteContract) {
        this.workerIndefiniteContract = indefiniteContract;
    }
}
