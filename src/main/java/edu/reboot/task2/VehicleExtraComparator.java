package edu.reboot.task2;

import java.util.Comparator;

public class VehicleExtraComparator implements Comparator<Vehicle> {

    public int compare(Vehicle a, Vehicle b) {
        return a.getExtra() - b.getExtra();
    }
}
