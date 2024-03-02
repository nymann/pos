package dev.nymann.pos;

public class CashRegister {
    private final Display display;
    private final ItemCatalog itemCatalog;

    public CashRegister(Display display, ItemCatalog itemCatalog) {
        this.itemCatalog = itemCatalog;
        this.display = display;
    }

    public void onBarcode(String barcode) {
        if (barcode == null || barcode.isEmpty()) {
            display.display("Read error");
            return;
        }
        display.display(this.itemCatalog.getPrice(barcode));
    }

}
