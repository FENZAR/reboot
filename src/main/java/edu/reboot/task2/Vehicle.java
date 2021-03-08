package edu.reboot.task2;

public abstract class Vehicle {
    private String type;
    private int number;
    private int mileage;
    private int extra;

    public Vehicle(String type, int number, int mileage) {
        this.type = type;
        this.number = number;
        this.mileage = mileage;
    }

    public Vehicle(String type, int number, int mileage, int extra) {
        this(type, number, mileage);
        this.extra = extra;
    }

    public String getType() { return type; }
    public int getNumber() { return number; }
    public int getMileage() { return mileage; }
    public int getExtra() { return extra; }

    public void setType(String type) { this.type = type; }
    public void setNumber(int number) { this.number = number; }
    public void setMileage(int mileage) { this.mileage = mileage; }
    public void setExtra(int extra) { this.extra = extra; }

    @Override
    public String toString() {

        return type + " " + number + " " + mileage + " " + extra;
    }

    public abstract void go();
}
