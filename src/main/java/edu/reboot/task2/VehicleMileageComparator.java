package edu.reboot.task2;

import java.util.Comparator;

public class VehicleMileageComparator implements Comparator<Vehicle> {
    
    public int compare(Vehicle a, Vehicle b) {
        return a.getMileage() - b.getMileage();
    }
}
