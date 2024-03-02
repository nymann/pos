package dev.nymann.pos;

import java.util.HashMap;
import java.util.Map;

public class ItemCatalog {
    private final Map<String, String> inventory;

    public ItemCatalog() {
        this.inventory = new HashMap<>();
    }


    public String getPrice(String barcode) {
        return this.inventory.getOrDefault(barcode, barcode + " is not registered");
    }

    public void add(String barcode, String price) {
        this.inventory.put(barcode, price);
    }
}
