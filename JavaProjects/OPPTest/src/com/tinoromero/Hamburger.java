package com.tinoromero;

public class Hamburger {
    private String name;
    private String breadRollType;
    private String meat;
    private double price;

    private String add1Name;
    private double add1Price;

    private String add2Name;
    private double add2Price;

    private String add3Name;
    private double add3Price;

    private String add4Name;
    private double add4Price;


    public Hamburger(String name, String breadRollType, String meat, double price) {
        this.name = name;
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.price = price;
    }

    public void addition1(String name, double price) {
        this.add1Name = name;
        this.add1Price = price;
    }

    public void addition2(String name, double price) {
        this.add2Name = name;
        this.add2Price = price;
    }

    public void addition3(String name, double price) {
        this.add3Name = name;
        this.add3Price = price;
    }

    public void addition4(String name, double price) {
        this.add4Name = name;
        this.add4Price = price;
    }

    public double itemizeHamburger() {
        double burgerPrice = this.price;
        System.out.println(this.name + " hamburger on a " + this.breadRollType + " roll and " + this.meat + " meat, price is " + this.price);

        if(this.add1Name != null) {
            burgerPrice += this.add1Price;
            System.out.println("Added " + this.add1Name + " for an extra " + this.add1Price);
        }

        if(this.add2Name != null) {
            burgerPrice += this.add2Price;
            System.out.println("Added " + this.add2Name + " for an extra " + this.add2Price);
        }

        if(this.add3Name != null) {
            burgerPrice += this.add3Price;
            System.out.println("Added " + this.add3Name + " for an extra " + this.add3Price);
        }

        if(this.add4Name != null) {
            burgerPrice += this.add4Price;
            System.out.println("Added " + this.add4Name + " for an extra " + this.add4Price);
        }

        return burgerPrice;
    }


}
