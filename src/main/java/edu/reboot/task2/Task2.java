package edu.reboot.task2;

import java.util.ArrayList;

public class Task2 {
    public static void main(String[] args) {
        ArrayListWrapper wrappedArrayList = new ArrayListWrapper(new ArrayList<>());
        wrappedArrayList.fillSameValues(10, 10);
        wrappedArrayList.setValueByIndex(2, 8);
        wrappedArrayList.addValueByIndex(11, 11);
        wrappedArrayList.addValueByIndex(7, 4);
        wrappedArrayList.printArraySize();
        wrappedArrayList.printArray();
        wrappedArrayList.removeValueByIndex(0);
        wrappedArrayList.printArray();
        wrappedArrayList.printMaxValue();
        wrappedArrayList.printMinValue();
        wrappedArrayList.printSortedArray(0);
        wrappedArrayList.printSortedArray(1);
    }
}
