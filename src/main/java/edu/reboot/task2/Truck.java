package edu.reboot.task2;

public class Truck extends Vehicle{

    public Truck(String type, int number, int mileage, int extra) {

        super(type, number, mileage, extra);
    }

    @Override
    public void go() {

        System.out.println("Transported the cargo by truck");
    }

}
