package com.tinoromero;

public class Main {

    public static void main(String[] args) {
        byte byteVal = 10;
	    short shortVal = 170;
	    int intVal = 430;

	    long longTotal = 50000L + (10L * (byteVal + shortVal + intVal));
	    short shortTotal = (short) (1000 + (10 * (byteVal + shortVal + intVal)));

        System.out.println("Long: " + longTotal);
        System.out.println("Short: " + shortTotal);

        float floatVal = 5.4f;
        double doubVal = 4d;
        double doubleVal = 4.25;

        System.out.println("Float: " + floatVal);
        System.out.println("Doubles: " + doubVal + "  " + doubleVal);

        // Es mejor usar doubles porque:
        // 1. Es mas preciso
        // 2. Las operaciones usan double por default
        // 3. Algunas computadoras los procesan mas rapido

        double pounds = 10d;
        double kilos = pounds * 0.453_592_37d;
        System.out.println(pounds + " lbs = " + kilos + " kg.");

        char charVal = 'A';
        char unicodeChar = '\u00A9';
        System.out.println("char: " + charVal);
        System.out.println("Unicode 00A9: " + unicodeChar);

        boolean boolVal = true;
    }
}
