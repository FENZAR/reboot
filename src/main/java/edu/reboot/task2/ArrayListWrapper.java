package edu.reboot.task2;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListWrapper {

    private ArrayList<Integer> arr;

    public ArrayListWrapper(ArrayList<Integer> arr) {
        this.arr = arr;
    }

    public void addValueByIndex(int index, int value) {
        if(index > this.arr.size())
            this.arr.add(value);
        else
            this.arr.add(index, value);
    }

    public void printArraySize() {
        System.out.println(this.arr.size());
    }

    public void removeValueByIndex(int index) {
        this.arr.remove(index);
    }

    public void setValueByIndex(int index, int value) {
        this.arr.set(index, value);
    }

    public void printArray() {
        System.out.println(this.arr);
    }

    public void printSortedArray(int order) {
        ArrayList<Integer> copy = new ArrayList<>(this.arr);
        if(order == 0)
            copy.sort(Comparator.naturalOrder());
        else
            copy.sort(Comparator.reverseOrder());
        System.out.println(copy);
    }

    public void printMaxValue(){
        System.out.println(this.arr.stream().max(Integer::compare).get());
    }

    public void printMinValue(){
        System.out.println(this.arr.stream().min(Integer::compare).get());
    }

    public void fillSameValues(int count, int value) {
        for(int i = 0; i < count; i++)
            this.arr.add(value);
    }

}
