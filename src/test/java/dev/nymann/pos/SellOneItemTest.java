package dev.nymann.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SellOneItemTest {
    private Display display;
    private BarcodeEventHandler barcodeEventHandler;

    @BeforeEach
    void setUp() {
        display = new Display();
        barcodeEventHandler = new BarcodeEventHandler(display);
    }

    @Test
    void When_anUnknownBarcodeIsScanned_aHelpfulErrorMessageIsDisplayedOnScreen() {
        String barcode = "812903";
        barcodeEventHandler.onBarcode(barcode);
        String expected = barcode + " is not registered";
        Assertions.assertEquals(expected, display.showText());
    }

    @Test
    void displayIsEmptyWhenNothingHasYetToBeScanned() {
        Assertions.assertTrue(display.showText().isEmpty());
    }

    @Test
    void When_aBarcodeIsScanned_theDisplayShowsThePrice() {
        String barcode = "12345";
        barcodeEventHandler.onBarcode(barcode);
        Assertions.assertEquals("$7.95", display.showText());
    }

    @Test
    void triangulation() {
        String barcode = "23456";
        barcodeEventHandler.onBarcode(barcode);
        Assertions.assertEquals("$12.95", display.showText());
    }
}