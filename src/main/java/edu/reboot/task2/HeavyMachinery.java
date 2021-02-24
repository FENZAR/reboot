package edu.reboot.task2;

public class HeavyMachinery extends Vehicle{

    private static final double FUEL_CONSUMPTION = 20.0;
    private static final double FUEL_COST = 48.90;

    private int liftedWeight;

    public HeavyMachinery(String type, int number, int mileage, int liftedWeight) {
        super(type, number, mileage);
        this.liftedWeight = liftedWeight;
    }

    public int getLiftedWeight() {
        return liftedWeight;
    }

    public void setLiftedWeight(int liftedWeight) {
        this.liftedWeight = liftedWeight;
    }

    @Override
    public void go() {

    }

    @Override
    public String toString() {
        return super.getType() + " " + super.getNumber() + " " + super.getMileage() + " " + this.getLiftedWeight();
    }
}
