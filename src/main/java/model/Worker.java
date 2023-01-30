package model;

public class Worker {
    // Class attributes
    private int workerId;
    private static int workerNumbers = 0;
    private String workerName;
    private String workerLastName;
    private boolean workerIndefiniteContract;
    private String workerPosition;

    // Associations
    private WorkerDevice workerDevice;

    public Worker(String workerName, String workerLastName, boolean workerContract, String workerPosition, WorkerDevice workerDevice) {
        workerId = ++workerNumbers;
        this.workerName = workerName;
        this.workerLastName = workerLastName;
        this.workerIndefiniteContract = workerContract;
        this.workerPosition = workerPosition;

        // Każdy pracownik musi mieć przynajmniej jeden sprzęt
        // Dlatego przypisujemy sprzęt pracownikowi w konstruktorze
        this.workerDevice = workerDevice;
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

    public WorkerDevice getWorkerDevice(){ return workerDevice;}

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
