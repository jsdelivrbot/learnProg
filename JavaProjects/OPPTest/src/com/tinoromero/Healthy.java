package com.tinoromero;

public class Healthy extends Hamburger {
    private String add5Name;
    private double add5Price;

    private String add6Name;
    private double add6Price;

    public Healthy(String meat, double price) {
        super("Healthy", "Brown Rye", meat, price);
    }

    public void addition5(String name, double price) {
        this.add5Name = name;
        this.add5Price = price;
    }

    public void addition6(String name, double price) {
        this.add6Name = name;
        this.add6Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double burgerPrice = super.itemizeHamburger();

        if(this.add5Name != null) {
            burgerPrice += this.add5Price;
            System.out.println("Added " + this.add5Name + " for an extra " + this.add5Price);
        }

        if(this.add6Name != null) {
            burgerPrice += this.add6Price;
            System.out.println("Added " + this.add6Name + " for an extra " + this.add6Price);
        }

        return burgerPrice;
    }
}
