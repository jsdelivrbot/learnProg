package com.tinoromero;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(false);

        System.out.println(printer.getPagesPrinted());
        System.out.println(printer.getTonerLevel());

        printer.printPages(10);
        printer.fillToner(20);
        printer.printPages(100);
        printer.printPages(1);
        printer.fillToner(3);
        printer.printPages(4);
        printer.printPages(3);
    }
}
