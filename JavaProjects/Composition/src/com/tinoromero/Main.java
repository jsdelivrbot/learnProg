package com.tinoromero;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case theCase = new Case("220B", "Dell", "240", dimensions);

        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));

        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(theCase, theMonitor, theMotherboard);
        thePC.powerUp();

        Table theTable = new Table("Dark Wood", 1, 2, 1, 6);
        Couch theCouch = new Couch("Beige", "Fethers", 4);
        LivingRoom livingRoom = new LivingRoom(4, 10, theTable, theCouch);

        livingRoom.getTable().serveTable();
        livingRoom.confyGuests();
    }
}
