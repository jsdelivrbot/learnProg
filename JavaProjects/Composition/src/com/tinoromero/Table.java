package com.tinoromero;

public class Table {
    private String material;
    private int width;
    private int length;
    private int height;
    private int numberOfPeople;

    public Table(String material, int width, int length, int height, int numberOfPeople) {
        this.material = material;
        this.width = width;
        this.length = length;
        this.height = height;
        this.numberOfPeople = numberOfPeople;
    }

    public void serveTable() {
        System.out.println("Serving table for " + numberOfPeople + " guests.");
    }

    public String getMaterial() {
        return material;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
}
