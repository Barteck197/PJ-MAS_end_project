package model;

import java.time.LocalDate;

public abstract class Software {
    private String softwareName;
    private String softwareVersion;
    private String softwareProducer;
    private LocalDate softwareInstallationDate;

    public Software(String softwareName, String softwareVersion, String softwareProducer, LocalDate softwareInstallationDate) {
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
        this.softwareProducer = softwareProducer;
        this.softwareInstallationDate = softwareInstallationDate;
    }
}
