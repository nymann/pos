package dev.nymann.pos;

public class SaleSystem {
    private final Display display;
    private final ItemCatalog itemCatalog;

    public SaleSystem(Display display) {
        itemCatalog = new ItemCatalog();
        this.display = display;
    }

    public void onBarcode(String barcode) {
        display.display(this.itemCatalog.getPrice(barcode));
    }

}