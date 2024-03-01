package dev.nymann.pos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SellOneItemTest {
    private Display display;
    private SaleSystem sale;

    @BeforeEach
    void setUp() {
        display = new Display();
        sale = new SaleSystem(display);
    }

    @Test
    void When_productIsNotFound_thenDisplayErrorMessage() {
        String barcode = "812903";
        sale.onBarcode(barcode);
        String expected = barcode + " is not registered";
        Assertions.assertEquals(expected, display.read());
    }

    @Test
    void When_nothingHasBeenScanned_thenDisplayIsEmpty() {
        Assertions.assertTrue(display.read().isEmpty());
    }

    @Test
    void When_productIsFound_thenDisplayThePrice() {
        String barcode = "12345";
        sale.onBarcode(barcode);
        Assertions.assertEquals("$7.95", display.read());
    }

    @Test
    void When_barcodeIsNull_thenShowReadErrorOnDisplay() {
        sale.onBarcode(null);
        Assertions.assertEquals("Read error", display.read());
    }

    @Test
    void When_anotherProductIsFound_thenDisplayThePrice() {
        String barcode = "23456";
        sale.onBarcode(barcode);
        Assertions.assertEquals("$12.95", display.read());
    }
}