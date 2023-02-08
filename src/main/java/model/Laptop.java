package model;

import java.time.LocalDate;

public class Laptop extends UserDevice {
    private float laptopScreenSize;     // Przekątna ekranu wyrażona w calach

    private Computer computer;

    /**
     * Kontruktor do tworzenia obiektów typu laptop. Konstruktor prywatny.
     * Tworzenie obiektów odbywa się przez dedykowaną metodę
     *
     * @param devicePurchaseDate
     * @param deviceBrand
     * @param deviceModel
     * @param deviceSerialNumber
     * @param deviceAmortizationTime
     * @param deviceInUse
     * @param workerDeviceLocation
     * @param workerDeviceIssueDate
     * @param laptopScreenSize       przekątna ekranu
     */
    private Laptop(LocalDate devicePurchaseDate, String deviceBrand,
                   String deviceModel, long deviceSerialNumber, int deviceAmortizationTime,
                   boolean deviceInUse, Site workerDeviceLocation, LocalDate workerDeviceIssueDate,
                   float laptopScreenSize, Computer computer) {
        super(devicePurchaseDate, deviceBrand, deviceModel,
                deviceSerialNumber, deviceAmortizationTime, deviceInUse,
                workerDeviceLocation, workerDeviceIssueDate);
        this.laptopScreenSize = laptopScreenSize;
    }

    /**
     * Metoda tworząca laptopa, kompozycja w klasie komputer
     *
     * @param computer komputer, którego częścią jest laptop
     */
    public static Laptop CreateLaptop(LocalDate devicePurchaseDate, String deviceBrand,
                                      String deviceModel, long deviceSerialNumber, int deviceAmortizationTime,
                                      boolean deviceInUse, Site workerDeviceLocation, LocalDate workerDeviceIssueDate,
                                      float laptopScreenSize, Computer computer) throws Exception {
        if (computer == null) {
            throw new Exception("Podany komputer nie istnieje");
        }

        // Utworzenie Laptopa
        Laptop l = new Laptop(devicePurchaseDate, deviceBrand, deviceModel,
                deviceSerialNumber, deviceAmortizationTime, deviceInUse, workerDeviceLocation,
                workerDeviceIssueDate, laptopScreenSize, computer);

        // Dodanie laptopa do Komputera
        computer.addLaptop(l);

        return l;
    }


}
