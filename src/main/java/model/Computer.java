package model;

public class Computer {
    private float computerCpu;
    private int computerRamMemory;
    private float computerHardDiskVolume;
    private String computerOperatingSystem;

    public Computer(float computerCpu, int computerRamMemory, float computerHardDiskVolume, String computerOperatingSystem) {
        this.computerCpu = computerCpu;
        this.computerRamMemory = computerRamMemory;
        this.computerHardDiskVolume = computerHardDiskVolume;
        this.computerOperatingSystem = computerOperatingSystem;
    }
}
