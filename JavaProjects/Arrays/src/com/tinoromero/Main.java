package com.tinoromero;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
	// write your code here
//        int[] myIntArray = new int[10];
//        myIntArray[5] = 50;
//        System.out.println(myIntArray[5]);
//
//        int[] myArray = { 1,2,3,4,5,6,7,8,9,10};
//        System.out.println(myArray[2]);
//        System.out.println(myArray[6]);
//
//        int[] loopedArray = new int[26];
//        for(int i = 0; i < loopedArray.length; i++) {
//            loopedArray[i] = i*10;
//        }
//        printArray(loopedArray);

        int[] myInts = getIntegers(5);
        printArray(myInts);
        System.out.println("The average is " + getAverage(myInts));
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "] = " + array[i]);
        }
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for(int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static double getAverage(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }

        double average = (double) sum / (double) array.length;

        return average;
    }
}
