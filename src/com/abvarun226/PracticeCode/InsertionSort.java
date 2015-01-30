package com.abvarun226.PracticeCode;

import java.util.Comparator;

/**
 * Created by bharghav on 1/29/15.
 */
public class InsertionSort<T extends Comparable> {
    public void sort(T[] data) {
        for (int i=1 ; i<data.length ; i++) {
            for (int j=i ; j>0 ; j--) {
                if (data[j-1].compareTo(data[j]) > 0) {
                    T swap = data[j];
                    data[j] = data[j-1];
                    data[j-1] = swap;
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String... args) {
        //Integer[] data = { 2, 4, 3 , 1, 5, 6, 8, 9 ,7, 10};
        //Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Integer[] intData = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort<Integer> obj1 = new InsertionSort<>();
        obj1.initiate(intData);

        String[] data = {"mars", "earth", "jupiter", "venus", "uranus", "neptune", "mercury", "pluto", "saturn"};
        InsertionSort<String> obj2 = new InsertionSort<>();
        obj2.initiate(data);
    }

    public void initiate(T[] data) {
        int count = 1;
        System.out.print("Original Data : [ ");
        for (T val : data) {
            if(count == data.length)
                System.out.print(val + " ]");
            else
                System.out.print(val + " , ");
            count++;
        }
        System.out.println();
        sort(data);
        count = 1;
        System.out.print("Sorted Data   : [ ");
        for (T val : data) {
            if(count == data.length)
                System.out.print(val + " ]");
            else
                System.out.print(val + " , ");
            count++;
        }
        System.out.println("\n");

    }
}
