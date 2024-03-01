package dev.nymann.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SellOneItemTest {
    private Display display;
    private SaleSystem barcodeEventHandler;

    @BeforeEach
    void setUp() {
        display = new Display();
        barcodeEventHandler = new SaleSystem(display);
    }

    @Test
    void When_anUnknownBarcodeIsScanned_aHelpfulErrorMessageIsDisplayedOnScreen() {
        String barcode = "812903";
        barcodeEventHandler.onBarcode(barcode);
        String expected = barcode + " is not registered";
        Assertions.assertEquals(expected, display.read());
    }

    @Test
    void displayIsEmptyWhenNothingHasYetToBeScanned() {
        Assertions.assertTrue(display.read().isEmpty());
    }

    @Test
    void When_aBarcodeIsScanned_theDisplayShowsThePrice() {
        String barcode = "12345";
        barcodeEventHandler.onBarcode(barcode);
        Assertions.assertEquals("$7.95", display.read());
    }

    @Test
    void triangulation() {
        String barcode = "23456";
        barcodeEventHandler.onBarcode(barcode);
        Assertions.assertEquals("$12.95", display.read());
    }
}