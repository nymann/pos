package dev.nymann.pos;

public class Display {
    private String text = "";

    public String read() {
        return text;
    }

    public void display(String text) {
        this.text = text;
    }
}
