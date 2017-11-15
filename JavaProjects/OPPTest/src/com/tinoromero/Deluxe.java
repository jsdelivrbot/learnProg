package com.tinoromero;

public class Deluxe extends Hamburger{
    public Deluxe() {
        super("Deluxe", "White", "Sausage and Bacon", 14.54);

        super.addition1("Chips", 0.80);
        super.addition2("Coca-Cola", 1.2);
    }

    @Override
    public void addition1(String name, double price) {
        System.out.println("Can't add additional items to burger.");
    }

    @Override
    public void addition2(String name, double price) {
        System.out.println("Can't add additional items to burger.");
    }

    @Override
    public void addition3(String name, double price) {
        System.out.println("Can't add additional items to burger.");
    }

    @Override
    public void addition4(String name, double price) {
        System.out.println("Can't add additional items to burger.");
    }
}
