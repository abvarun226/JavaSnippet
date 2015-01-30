package com.abvarun226.PracticeCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by bharghav on 1/29/15.
 */
public class BinarySearchStrings {
    static String[] values = {"hello", "world", "welcome", "apple", "orange", "mango"};

    static int search(String key, int start, int end) {
        if(end < start) {
            return -1;
        }
        int middle = start + (end-start)/2;
        int cmp = key.compareToIgnoreCase(values[middle]);
        if(cmp < 0) {
            return search(key, start, middle-1);
        } else if(cmp > 0) {
            return search(key, middle+1, end);
        } else {
            return middle;
        }
    }

    public static void main(String... args) {
        String key = "orange";

        Arrays.sort(values);
        int count = 1;
        System.out.print("[ ");
        for (String str : values) {
            if(count == values.length) {
                System.out.println(str + " ]");
            } else {
                System.out.print(str + " , ");
            }
            count++;
        }
        System.out.println("\n");
        int index = search(key, 0, values.length-1);
        if(index >= 0 ) {
            System.out.println("Key '" + key + "' found at index " + index);
        } else {
            System.out.println("Key '" + key + "' not found");
        }
    }

}
