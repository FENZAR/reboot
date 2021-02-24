package edu.reboot.task2;

public abstract class Vehicle implements Comparable<Vehicle>{
    private String type;
    private int number;
    private int mileage;

    public Vehicle(String type, int number, int mileage) {
        this.type = type;
        this.number = number;
        this.mileage = mileage;
    }

    public String getType() { return type; }
    public int getNumber() { return number; }
    public int getMileage() { return mileage; }

    public void setType(String type) { this.type = type; }
    public void setNumber(int number) { this.number = number; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    @Override
    public int compareTo(Vehicle o) {
        return (int)(this.mileage - o.getMileage());
    }

    @Override
    public String toString() {
        return type + " " + number + " " + mileage;
    }

    public abstract void go();
}
