package com.tinoromero;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(boolean duplex) {
        this.tonerLevel = 100;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public void fillToner(int fillPercentage) {
        if((fillPercentage + tonerLevel) > 100) {
            System.out.println("Toner filled.");
            this.tonerLevel = 100;
        } else {
            this.tonerLevel += fillPercentage;
        }
        System.out.println("Toner filled. Toner level: " + this.tonerLevel);
    }

    public void printPages(int pages) {
        int ink = pages * 1;
        if(this.tonerLevel >= ink) {
            if(duplex) {
                int pair = pages % 2;
                pages /= 2;
                pages += pair;
            }
            this.tonerLevel -= ink;
            System.out.println("Printed " + pages + " pages.");
            System.out.println(this.tonerLevel + "% toner remaining.");
        } else {
            System.out.println("Toner level too low to print " + pages + " pages.");
        }
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
