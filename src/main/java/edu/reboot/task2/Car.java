package edu.reboot.task2;

public class Car extends Vehicle {

    private static final double FUEL_CONSUMPTION = 12.5;
    private static final double FUEL_COST = 46.10;

    // private static double currentCost;

    public Car(String type, int number, int mileage) {
        super(type, number, mileage);
    }

    @Override
    public void go() {
        System.out.println("Car is going");
    }
}
