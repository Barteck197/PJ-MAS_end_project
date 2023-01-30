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
    private static Set<Server> allRackServers;

    /**
     * The constructor
     *
     * @param deviceId               Id sprzętu
     * @param devicePurchaseDate     Data zakupu sprzętu
     * @param deviceBrand            Marka
     * @param deviceModel            Model
     * @param deviceSerialNumber     Numer seryjny
     * @param deviceAmortizationTime Czas amortyzacji
     * @param deviceInUse            Czy sprzęt jest w użyciu
     * @param serverDeviceMountDate  Data montażu urządzenia
     */

    public Rack(int deviceId, LocalDate devicePurchaseDate,
                String deviceBrand, String deviceModel,
                float deviceSerialNumber, int deviceAmortizationTime,
                boolean deviceInUse, LocalDate serverDeviceMountDate,
                int rackHeight, int rackWidth, int rackLength, int rackVolume) {
        super(deviceId, devicePurchaseDate, deviceBrand, deviceModel, deviceSerialNumber, deviceAmortizationTime, deviceInUse, serverDeviceMountDate);
        this.rackHeight = rackHeight;
        this.rackWidth = rackWidth;
        this.rackLength = rackLength;
        this.rackVolume = rackVolume;
        rackServers = new HashMap<>();
    }

    public void addServerToRack(Server newServer) throws Exception {
        // TODO - sprawdzenie czy dana wartość jest w mapie
        if (!rackServers.containsKey(newServer)) {
            // Jeśli serwer nie jest już przypisany do jakiejś szafy
            if (allRackServers.contains(newServer)) {
                throw new Exception("Ten serwer jest już przypisany do szafy.");
            }
            rackServers.put(newServer.getServerPositionInRack(), newServer);
            allRackServers.add(newServer);
        }
    }

    public Server findServerInRack(int serverPosition) throws Exception {
        if (!rackServers.containsKey(serverPosition))
            throw new Exception("Nie ma serwera na podanym miejscu w szafie.");

        return rackServers.get(serverPosition);
    }
}
