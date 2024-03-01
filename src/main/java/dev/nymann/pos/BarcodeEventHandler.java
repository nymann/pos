package dev.nymann.pos;

public class BarcodeEventHandler {
    private final Display display;
    private final ItemCatalog itemCatalog;

    public BarcodeEventHandler(Display display) {
        itemCatalog = new ItemCatalog();
        this.display = display;
    }

    public void onBarcode(String barcode) {
        display.setText(this.itemCatalog.getPrice(barcode));
    }

}
