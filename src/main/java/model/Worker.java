package model;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    // Class attributes
    private int workerId;
    private static int workerNumbers = 0;
    private String workerName;
    private String workerLastName;
    private boolean workerIndefiniteContract;
    private String workerPosition;

    // Associations
    private List<WorkerDevice> workerDevices;

    /**
     * Konstruktor klasy pracownik
     *
     * @param workerName     Imię
     * @param workerLastName Nazwisko
     * @param workerContract Czy ma umowę na czas nieokreślony
     * @param workerPosition Stanowisko w firmie
     * @param workerDevice   Sprzęt pracownika
     */
    public Worker(String workerName, String workerLastName, boolean workerContract, String workerPosition, WorkerDevice workerDevice) {
        workerId = ++workerNumbers;
        this.workerName = workerName;
        this.workerLastName = workerLastName;
        this.workerIndefiniteContract = workerContract;
        this.workerPosition = workerPosition;

        // Każdy pracownik musi mieć przynajmniej jeden sprzęt
        // Dlatego przypisujemy sprzęt pracownikowi w konstruktorze
        workerDevices = new ArrayList<>();
        workerDevices.add(workerDevice);
    }

    /**
     * Dodawanie sprzętu pracownika do listy jego sprzętu.
     *
     * @param newDevice nowy sprzęt do dodania
     */
    public void addWorkerDevice(WorkerDevice newDevice) {
        if (!workerDevices.contains(newDevice)) {
            workerDevices.add(newDevice);

            newDevice.setWorkerDeviceOwner(this);
        }
    }

    /**
     * Usuwanie sprzętu przypisanego do pracownika
     *
     * @param oldDevice stary sprzęt
     */
    public void removeWorkerDevice(WorkerDevice oldDevice) {
        workerDevices.remove(oldDevice);
//        oldDevice.rem
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

    public List<WorkerDevice> getWorkerDevices() {
        return workerDevices;
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
