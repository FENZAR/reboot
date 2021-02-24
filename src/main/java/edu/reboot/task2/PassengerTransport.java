package edu.reboot.task2;

public class PassengerTransport extends Vehicle {

    private static final double FUEL_CONSUMPTION = 11.5;
    private static final double FUEL_COST = 47.50;

    private int passangerCount;

    public PassengerTransport(String type, int number, int mileage, int passangerCount) {
        super(type, number, mileage);
        this.passangerCount = passangerCount;
    }

    public int getPassangerCount() {
        return passangerCount;
    }

    public void setPassangerCount(int passangerCount) {
        this.passangerCount = passangerCount;
    }

    @Override
    public void go() {

    }

    @Override
    public String toString() {
        return super.getType() + " " + super.getNumber() + " " + super.getMileage() + " " + this.getPassangerCount();
    }
}
