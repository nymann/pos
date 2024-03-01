package dev.nymann.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SellOneItemTest {
    @Test
    void name() {
        Display display = new Display();
        Applesauce applesauce = new Applesauce(display);
        String barcode = "12345";
        applesauce.onScan(barcode);
        Assertions.assertEquals("7.95$", display.showText());
    }
}