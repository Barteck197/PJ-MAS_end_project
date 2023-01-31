package model;

import java.time.LocalDate;

public class LicensedSoftware extends Software{
    private LocalDate licensedSoftPurchaseDate;
    private LocalDate licensingPeriod;
    private int licensedSoftwareNumber;

    /**
     * Konstruktor do tworzenia obiektów typu oprogramowanie z licencją
     * @param softwareName nazwa oprogramowania
     * @param softwareVersion wersja
     * @param softwareProducer producent
     * @param softwareInstallationDate data instalacji
     * @param licensedSoftPurchaseDate data zakupu
     * @param licensingPeriod okres licencjonowania
     * @param licensedSoftwareNumber liczba licencji
     */
    public LicensedSoftware(String softwareName, String softwareVersion, String softwareProducer,
                            LocalDate softwareInstallationDate, LocalDate licensedSoftPurchaseDate,
                            LocalDate licensingPeriod, int licensedSoftwareNumber) {
        super(softwareName, softwareVersion, softwareProducer, softwareInstallationDate);
        this.licensedSoftPurchaseDate = licensedSoftPurchaseDate;
        this.licensingPeriod = licensingPeriod;
        this.licensedSoftwareNumber = licensedSoftwareNumber;
    }
}
