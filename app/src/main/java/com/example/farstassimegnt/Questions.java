package com.example.farstassimegnt;

public class Questions {
    private String element;
    private int electronNumber;

    public Questions(String element, int electronNumber) {
        this.element = element;
        this.electronNumber = electronNumber;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public int getElectronNumber() {
        return electronNumber;
    }

    public void setElectronNumber(int electronNumber) {
        this.electronNumber = electronNumber;
    }
}
