package dev.nymann.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SellOneItemTest {
    @Test
    void When_aBarcodeIsScanned_theDisplayShowsThePrice() {
        Display display = new Display();
        BarcodeEventHandler applesauce = new BarcodeEventHandler(display);
        String barcode = "12345";
        Assertions.assertEquals("", display.showText());
        applesauce.onBarcode(barcode);
        Assertions.assertEquals("7.95$", display.showText());
    }

    @Test
    void triangulation() {
        Display display = new Display();
        BarcodeEventHandler applesauce = new BarcodeEventHandler(display);
        String barcode = "23456";
        applesauce.onBarcode(barcode);
        Assertions.assertEquals("12.95$", display.showText());
    }
}