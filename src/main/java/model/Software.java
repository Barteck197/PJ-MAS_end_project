package model;

import utils.ObjectPlus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Software extends ObjectPlus {
    private String softwareName;
    private String softwareVersion;
    private String softwareProducer;
    private LocalDate softwareInstallationDate;

    private List<Computer> softwareOnComputers;
    private PurchaseOrder softwarePurhcaseOrder;

    public Software(String softwareName, String softwareVersion, String softwareProducer, LocalDate softwareInstallationDate) {
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
        this.softwareProducer = softwareProducer;
        this.softwareInstallationDate = softwareInstallationDate;
        softwareOnComputers = new ArrayList<>();
    }

    /**
     * Tworzenie asocjacji z klasą Computer
     *
     * @param newComputer komputer na którym właśnie zainstalowano oprogramowanie
     */
    public void addComputer(Computer newComputer) {
        if (!softwareOnComputers.contains(newComputer)) {
            softwareOnComputers.add(newComputer);
            newComputer.addSoftware(this);
        }
    }

    /**
     * Usuwanie asocjacji z klasą Computer
     *
     * @param oldComputer komputer do usunięcia
     */
    public void removeComputer(Computer oldComputer) {
        softwareOnComputers.remove(oldComputer);
        oldComputer.removeSoftware(this);
    }

    /**
     * Tworzenie asocjacji z klasa zamówienie
     *
     * @param newPurchaseOrder zamówienie do przypisania do oprogramowania
     */
    public void addPurchaseOrder(PurchaseOrder newPurchaseOrder) {
        if (softwarePurhcaseOrder != newPurchaseOrder){
            softwarePurhcaseOrder = newPurchaseOrder;
            newPurchaseOrder.addSoftware(this);
        }
    }

    /**
     * Usuwanie asocjacji z klasą zamówienie
     *
     * @param oldPO
     */
    public void removePurchaseOrder(PurchaseOrder oldPO) {
        if(softwarePurhcaseOrder != null){
            softwarePurhcaseOrder = null;
            oldPO.removeSoftware(this);
        }
    }
}
