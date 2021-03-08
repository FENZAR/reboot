package edu.reboot.task2;

public class Car extends Vehicle {

    public Car(String type, int number, int mileage) {

        super(type, number, mileage);
    }

    @Override
    public void go() {

        System.out.println("Car is going");
    }

}
