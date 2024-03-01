package dev.nymann.pos;

public class ItemCatalog {
    public String getPrice(String barcode) {
        String price;
        if ("12345".equals(barcode)) {
            price = "7.95$";
        } else if ("23456".equals(barcode)) {
            price = "12.95$";
        } else {
            throw new RuntimeException(barcode + " not found in inventory");
        }
        return price;
    }
}
