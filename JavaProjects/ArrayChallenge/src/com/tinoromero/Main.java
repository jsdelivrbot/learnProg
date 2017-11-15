package com.tinoromero;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.printf("Enter length of array: ");
        int length = scanner.nextInt();

        int[] myInts = getIntegers(length);
        printArray(myInts);

        int[] sortedArray = sortArray(myInts);
        printArray(sortedArray);
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values:");
        int[] values = new int[number];

        for(int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }

        return values;
    }

    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("[" + i + "] = " + array[i]);
        }
    }

    public static int[] sortArray(int[] array) {
        int[] sortedArray;
        sortedArray = Arrays.copyOf(array, array.length);

        System.out.println("Sorted array is:");
        for(int i = 0; i < sortedArray.length; i++) {
            for(int j = i + 1; j < sortedArray.length; j++) {
                if(sortedArray[j] > sortedArray[i]) {
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[i];
                    sortedArray[i] = temp;
                }
            }
        }

        return sortedArray;
    }
}
