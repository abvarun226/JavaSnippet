package com.abvarun226.PracticeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by bharghav on 1/29/15.
 */
public class BinarySearch {
    static Integer[] values = {2, 5, 4, 3, 1, 6, 8, 9, 7, 5};
    //static ArrayList<Integer> data = new ArrayList<>(Arrays.asList(values));

    public static int search(int key, int start, int end) {
        if (end < start) {
            return -1;
        } else {
            int middle = start + (end - start)/2;
            if(key < values[middle]) {
                return search(key, start, middle-1);
            } else if (key > values[middle]) {
                return search(key, middle+1, end);
            } else {
                return middle;
            }
        }

    }

    public static void main(String... args) {
        int searchFor = 6;
        //Collections.sort(data);
        Arrays.sort(values);
        System.out.print("[ ");
        for (Integer val : values) {
            System.out.print(val + " ");
        }
        System.out.println("]\n");
        int index = search(searchFor, 0, values.length -1);
        if (index >= 0) {
            System.out.println("Key found at index " + index);
        } else {
            System.out.println("Key not found");
        }

    }
}
