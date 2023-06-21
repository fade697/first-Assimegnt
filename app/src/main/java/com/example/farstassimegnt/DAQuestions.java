package com.example.farstassimegnt;

import java.util.ArrayList;

public class DAQuestions {
    private ArrayList<Questions> questionsList = new ArrayList<>();

    public DAQuestions() {
        questionsList.add(new Questions("Fe", 26));
        questionsList.add(new Questions("Na", 11));
        questionsList.add(new Questions("O", 8));
        questionsList.add(new Questions("Cu", 29));
        questionsList.add(new Questions("He", 2));
        questionsList.add(new Questions("Cl", 17));
        questionsList.add(new Questions("Au", 79));
        questionsList.add(new Questions("Ne", 10));
        questionsList.add(new Questions("K", 19));
        questionsList.add(new Questions("S", 16));
        questionsList.add(new Questions("Zn", 30));
        questionsList.add(new Questions("Br", 35));
        questionsList.add(new Questions("Al", 13));
        questionsList.add(new Questions("N", 7));
        questionsList.add(new Questions("Hg", 80));
        questionsList.add(new Questions("C", 6));
        questionsList.add(new Questions("Li", 3));
        questionsList.add(new Questions("Ag", 47));
        questionsList.add(new Questions("Mg", 12));
        questionsList.add(new Questions("Si", 14));
        questionsList.add(new Questions("P", 15));
    }

    public ArrayList<Questions> getQuestionsList() {
        return questionsList;
    }
}
