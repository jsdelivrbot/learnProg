package com.tinoromero;

class Car {
    private String name;
    private boolean engine;
    private int cylinders;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = true;
        this.wheels = 4;
    }

    public void startEngine() {
        System.out.println("Car engine started.");
    }

    public void accelerate() {
        System.out.println("Car accelerating.");
    }

    public void brake() {
        System.out.println("Car brakes activated.");
    }

    public String getName() {
        return name;
    }

    public boolean isEngine() {
        return engine;
    }

    public int getCylinders() {
        return cylinders;
    }

    public int getWheels() {
        return wheels;
    }
}

class Tiida extends Car {
    public Tiida() {
        super("Tiida", 4);
    }

    @Override
    public void startEngine() {
        System.out.println("Tidda engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("Tiida accelerated");
    }
}

class Navigator extends Car {
    public Navigator() {
        super("Navigator", 8);
    }

    @Override
    public void startEngine() {
        System.out.println("Navigator's engine started");
    }

    @Override
    public void accelerate() {
        System.out.println("Navigator making huge noises");
    }

    @Override
    public void brake() {
        System.out.println("Navigator has fully stopped");
    }
}

class Verna extends Car {
    public Verna() {
        super("Verna", 4);
    }
}

public class Main {

    public static void main(String[] args) {
        Car car = randomCar();
        System.out.println("Car is a " + car.getName() +
                            " and has " + car.getCylinders() +
                            " cylinders.");
        car.startEngine();
        car.accelerate();
        car.brake();
    }

    public static Car randomCar() {
        int randomNum = (int) (Math.random() * 3) + 1;
        switch(randomNum) {
            case 1:
                return new Tiida();
            case 2:
                return new Navigator();
            case 3:
                return new Verna();
        }

        return null;
    }
}
