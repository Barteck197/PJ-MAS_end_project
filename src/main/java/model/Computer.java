package model;

import model.oplus.ObjectPlus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer extends ObjectPlus {
    private float computerCpu;
    private int computerRamMemory;
    private float computerHardDiskVolume;
    private String computerOperatingSystem;

    private List<Software> computerInstaledSoftware;

    // Lista serwerów przypisanych do komputera
    private List<Server> servers = new ArrayList<>();

    // Lista laptopów przypisanych do komputera
    private List<Laptop> laptops = new ArrayList<>();

    // Lista wszystkich laptopoów
    private static Set<Laptop> allLaptops = new HashSet<>();

    // Lista wszystkich serwerów
    private static Set<Server> allServers = new HashSet<>();

    /**
     * Konstruktor do tworzenia obiektów klasy Komputer
     *
     * @param computerCpu             taktowanie procesora
     * @param computerRamMemory       pamięć ram
     * @param computerHardDiskVolume  pojemność dysku
     * @param computerOperatingSystem system operacyjny
     */
    public Computer(float computerCpu, int computerRamMemory, float computerHardDiskVolume, String computerOperatingSystem) {
        super();
        this.computerCpu = computerCpu;
        this.computerRamMemory = computerRamMemory;
        this.computerHardDiskVolume = computerHardDiskVolume;
        this.computerOperatingSystem = computerOperatingSystem;
        computerInstaledSoftware = new ArrayList<>();
    }

    /**
     * Metoda obsługująca tworzenie asocjacji
     *
     * @param newSoftware nowe oprogramowanie do dodania
     */
    public void addSoftware(Software newSoftware) {
        if (!computerInstaledSoftware.contains(newSoftware)) {
            computerInstaledSoftware.add(newSoftware);
            newSoftware.addComputer(this);
        }
    }

    /**
     * Obsługiwanie zakończenia asocjacji
     *
     * @param oldSoftware oprogramowanie do usunięcia
     */
    public void removeSoftware(Software oldSoftware) {
        computerInstaledSoftware.remove(oldSoftware);
        oldSoftware.removeComputer(this);
    }

    /**
     * Tworzenie kompozycji z obiektem laptop
     *
     * @param lap laptop do dodania
     * @throws Exception wyjątek jeśli laptop jest już przypisany do komputera
     */
    public void addLaptop(Laptop lap) throws Exception {
        if (!laptops.contains(lap)) {
            // Czy nowy laptop nie jest już częścią jakiegoś komputera
            if (allLaptops.contains(lap)) {
                throw new Exception("Nie można dodać komputera");
            }
            laptops.add(lap);
            allLaptops.add(lap);
        }
    }

    /**
     * Tworzenie kompozycji z obiektem serwer
     *
     * @param srv serwer do dodania
     * @throws Exception wyjątek jeśli serwer jest już przypisany do jakiegoś komputera
     */
    public void addServer(Server srv) throws Exception {
        if (!servers.contains(srv)) {
            if (allServers.contains(srv)) {
                throw new Exception("Nie można dodać serwera");
            }
            servers.add(srv);
            allServers.add(srv);
        }
    }
}
