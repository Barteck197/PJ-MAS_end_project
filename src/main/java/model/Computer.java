package model;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private float computerCpu;
    private int computerRamMemory;
    private float computerHardDiskVolume;
    private String computerOperatingSystem;

    private List<Software> computerInstaledSoftware;

    private List<Server> servers;

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
        computerInstaledSoftware = new ArrayList<>();
        servers = new ArrayList<>();
    }

    /**
     * Metoda obsługująca tworzenie asocjacji
     * @param newSoftware nowe oprogramowanie do dodania
     */
    public void addSoftware(Software newSoftware){
        if(!computerInstaledSoftware.contains(newSoftware)){
            computerInstaledSoftware.add(newSoftware);
            newSoftware.addComputer(this);
        }
    }

    /**
     * Obsługiwanie zakończenia asocjacji
     * @param oldSoftware oprogramowanie do usunięcia
     */
    public void removeSoftware(Software oldSoftware){
        computerInstaledSoftware.remove(oldSoftware);
        oldSoftware.removeComputer(this);
    }
}
