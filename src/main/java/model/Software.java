package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Software {
    private String softwareName;
    private String softwareVersion;
    private String softwareProducer;
    private LocalDate softwareInstallationDate;

    private List<Computer> softwareOnComputers;

    public Software(String softwareName, String softwareVersion, String softwareProducer, LocalDate softwareInstallationDate) {
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
        this.softwareProducer = softwareProducer;
        this.softwareInstallationDate = softwareInstallationDate;
        softwareOnComputers = new ArrayList<>();
    }

    /**
     * Tworzenie asocjacji z klasą Computer
     * @param newComputer komputer na którym właśnie zainstalowano oprogramowanie
     */
    public void addComputer(Computer newComputer){
        if(!softwareOnComputers.contains(newComputer)){
            softwareOnComputers.add(newComputer);
            newComputer.addSoftware(this);
        }
    }

    /**
     * Usuwanie asocjacji z klasą Computer
     * @param oldComputer komputer do usunięcia
     */
    public void removeComputer(Computer oldComputer){
        softwareOnComputers.remove(oldComputer);
        oldComputer.removeSoftware(this);
    }
}
