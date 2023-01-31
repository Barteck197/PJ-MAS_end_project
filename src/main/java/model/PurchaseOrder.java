package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrder {
    private static int nextPurchaseOrderID = 0;

    private int purchaseOrderNumber;
    private LocalDate orderPlaceDate;
    private int quantity;

    private List<Device> orderDevices = new ArrayList<>();
    private List<Software> orderSoftware = new ArrayList<>();

    /**
     * Konstruktor klasy: Zamówienie sprzętu
     * @param orderPlaceDate Data złożenia zamówienia
     * @param quantity Ilość
     * @param deviceToOrder Sprzęt do zamówienia
     */
    public PurchaseOrder(LocalDate orderPlaceDate, int quantity, Device deviceToOrder) {
        this.orderPlaceDate = orderPlaceDate;
        this.quantity = quantity;
        this.purchaseOrderNumber = nextPurchaseOrderID++;
        orderDevices.add(deviceToOrder);
    }

    /**
     * Konstruktor klasy: zamówienie oprogramowania
     * @param orderPlaceDate
     * @param quantity
     * @param softwareToOrder
     */
    public PurchaseOrder(LocalDate orderPlaceDate, int quantity, Software softwareToOrder) {
        this.orderPlaceDate = orderPlaceDate;
        this.quantity = quantity;
        orderSoftware.add(softwareToOrder);
    }

    public void addDevice(Device newDevice){
        if(!orderDevices.contains(newDevice)){
            orderDevices.add(newDevice);
            newDevice.addPurchaseOrder(this);
        }
    }

    public void removeDevice(Device oldDevice){
        orderDevices.remove(oldDevice);
        oldDevice.removePurchaseOrder();
    }

    public void addSoftware(Software newSoftware){
        if(!orderSoftware.contains(newSoftware)){
            orderSoftware.add(newSoftware);
            newSoftware.addPurchaseOrder(this);
        }
    }

    public void removeSoftware(Software oldSoftware){
        orderSoftware.remove(oldSoftware);
        oldSoftware.removePurchaseOrder(this);
    }
}
