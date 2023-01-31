package model;

import java.time.LocalDate;

public class PurchaseOrder {
    private static int nextPurchaseOrderID = 0;

    private int purchaseOrderNumber;
    private LocalDate orderPlaceDate;
    private int quantity;

    /**
     * Konstruktor klasy: Zamówienie
     * @param orderPlaceDate Data złożenia zamówienia
     * @param quantity Ilość
     */
    public PurchaseOrder(LocalDate orderPlaceDate, int quantity) {
        this.orderPlaceDate = orderPlaceDate;
        this.quantity = quantity;
        this.purchaseOrderNumber = nextPurchaseOrderID++;
    }
}
