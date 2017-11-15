package com.tinoromero;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Tiida tiida = new Tiida(36);
        tiida.accelerate(30);
        tiida.steer(45);
        tiida.accelerate(30);
        tiida.accelerate(20);
        tiida.accelerate(-42);
    }
}
