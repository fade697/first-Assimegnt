package com.example.farstassimegnt;

public class Questions {
    private String element;
    private int electronNumber;
    private String answer;

    public Questions(String element, int electronNumber) {
        this.element = element;
        this.electronNumber = electronNumber;
        this.answer = ""; // Initialize the answer as an empty string
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

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
