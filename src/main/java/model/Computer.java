package model;

public class Computer {
    private float computerCpu;
    private int computerRamMemory;
    private float computerHardDiskVolume;
    private String computerOperatingSystem;

    /**
     * Konstruktor do tworzenia obiektów klasy Komputer
     * @param computerCpu taktowanie procesora
     * @param computerRamMemory pamięć ram
     * @param computerHardDiskVolume pojemność dysku
     * @param computerOperatingSystem system operacyjny
     */
    public Computer(float computerCpu, int computerRamMemory, float computerHardDiskVolume, String computerOperatingSystem) {
        this.computerCpu = computerCpu;
        this.computerRamMemory = computerRamMemory;
        this.computerHardDiskVolume = computerHardDiskVolume;
        this.computerOperatingSystem = computerOperatingSystem;
    }
}
