package edu.reboot.task2;

public class Truck extends Vehicle{

    private static final double FUEL_CONSUMPTION = 12.0;
    private static final double FUEL_COST = 48.90;
    private int cargoVolume;

    public Truck(String type, int number, int mileage, int cargoVolume) {
        super(type, number, mileage);
        this.cargoVolume = cargoVolume;
    }

    public int getCargoVolume() {
        return cargoVolume;
    }

    public void setCargoVolume(int cargoVolume) {
        this.cargoVolume = cargoVolume;
    }

    @Override
    public void go() {
        System.out.println("Transported the cargo by truck");
    }

    @Override
    public String toString() {
        return super.getType() + " " + super.getNumber() + " " + super.getMileage() + " " + this.getCargoVolume();
    }
}
