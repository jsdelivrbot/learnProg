package com.tinoromero;

public class Couch {
    private String color;
    private String material;
    private int numberOfPeople;

    public Couch(String color, String material, int numberOfPeople) {
        this.color = color;
        this.material = material;
        this.numberOfPeople = numberOfPeople;
    }

    public void sitGuests() {
        System.out.println("Sitting " + numberOfPeople + " guests on couch.");
    }
}
