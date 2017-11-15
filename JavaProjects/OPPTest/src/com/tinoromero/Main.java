package com.tinoromero;

public class Main {

    public static void main(String[] args) {
        Hamburger basic = new Hamburger("Basic", "White","Sausage", 3.56);
//        double price = basic.itemizeHamburger();
        basic.addition1("Tomato", 0.27);
        basic.addition2("Lettuce", 0.75);
        basic.addition3("Cheese", 1.13);
        System.out.println("Total Burger price is " + basic.itemizeHamburger());

        Healthy healthy = new Healthy("Bacon", 6.66);
        healthy.itemizeHamburger();
        healthy.addition5("Egg", 5.43);
        healthy.addition6("Lentils", 3.41);
        System.out.println("Total Healthy Burger price is " + healthy.itemizeHamburger());

        Deluxe db = new Deluxe();
        db.itemizeHamburger();
        db.addition3("Egg", 10);
        System.out.println("Total Deluxe Burger price is " + db.itemizeHamburger());
    }
}
