package dev.nymann.pos;

import java.util.HashMap;
import java.util.Map;

public class ItemCatalog {
    private final Map<String, String> inventory;

    public ItemCatalog() {
        this.inventory = new HashMap<>();
        this.inventory.put("12345", "$7.95");
        this.inventory.put("23456", "$12.95");
    }

    public String getPrice(String barcode) {
        return this.inventory.getOrDefault(barcode, barcode + " is not registered");
    }
}
