package model;

import java.time.LocalDate;
import java.util.*;

public class Rack extends ServerDevice {
    // Wysokość szafy
    private int rackHeight;
    // Szerokość
    private int rackWidth;
    // Długość - głębokość
    private int rackLength;
    // Liczba wolnych zamków
    private int rackVolume;

    // Atrybuty pod asocjację (z atrybutem)
    private Map<Integer, Server> rackServers;
    private static Set<Server> allRackServers = new HashSet<>();

    /**
     * The constructor
     *
     * @param devicePurchaseDate     Data zakupu sprzętu
     * @param deviceBrand            Marka
     * @param deviceModel            Model
     * @param deviceSerialNumber     Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse            Czy sprzęt jest w użyciu
     * @param serverDeviceMountDate  Data montażu urządzenia
     */

    public Rack(LocalDate devicePurchaseDate,
                String deviceBrand, String deviceModel,
                float deviceSerialNumber, int deviceAmortizationTime,
                boolean deviceInUse, LocalDate serverDeviceMountDate,
                int rackHeight, int rackWidth, int rackLength, int rackVolume) {
        super(devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse, serverDeviceMountDate);
        this.rackHeight = rackHeight;
        this.rackWidth = rackWidth;
        this.rackLength = rackLength;
        this.rackVolume = rackVolume;
        rackServers = new HashMap<>();
    }

    /**
     * Dodanie serwera do szafy rack.
     *
     * @param newServer instancja obiektu serwera do zainstalowania w szafie
     * @throws Exception wyjątek jeśli próba ponownego przypisania już zainstalowanego serwera
     */
    public void addServerToRack(Server newServer) throws Exception {
        // Jeśli dany serwer nie jest już zainstalowany w tej konkretnej szafie...
        if (!rackServers.containsKey(newServer.getServerPositionInRack())) {
            // ... i jeśli serwer nie jest już przypisany do jakiejś szafy
            if (allRackServers.contains(newServer)) {
                throw new Exception("Ten serwer jest już przypisany do szafy.");
            }
            rackServers.put(newServer.getServerPositionInRack(), newServer);
            allRackServers.add(newServer);
        }
    }

    /**
     * Wyszukiwanie serwera w szafie na podstawie kwalifikatora
     *
     * @param serverPosition kwalifikator
     * @return obiekt serwera
     * @throws Exception wyjątek jeśli serwera nie znaleziono w szafie
     */
    public Server findServerInRack(int serverPosition) throws Exception {
        if (!rackServers.containsKey(serverPosition))
            throw new Exception("Nie ma serwera na podanym miejscu w szafie.");

        return rackServers.get(serverPosition);
    }

    /**
     * Usuwanie starego serwera z szafy
     *
     * @param oldServer stary serwer
     */
    public void removeServer(Server oldServer) {
        rackServers.remove(oldServer.getServerPositionInRack());
    }

    public List<Server> getServers(){
        return new ArrayList<>(rackServers.values());
    }
    public int getRackHeight() {
        return rackHeight;
    }

    public void setRackHeight(int rackHeight) {
        this.rackHeight = rackHeight;
    }

    public int getRackWidth() {
        return rackWidth;
    }

    public void setRackWidth(int rackWidth) {
        this.rackWidth = rackWidth;
    }

    public int getRackLength() {
        return rackLength;
    }

    public void setRackLength(int rackLength) {
        this.rackLength = rackLength;
    }

    public int getRackVolume() {
        return rackVolume;
    }

    public void setRackVolume(int rackVolume) {
        this.rackVolume = rackVolume;
    }
}
