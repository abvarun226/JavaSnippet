package com.abvarun226.CollectionsDemo;

import java.util.ArrayList;

/**
 * Created by bharghav on 1/23/15.
 */
public class ArrayListDemo1 {
    public static void main(String... args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        System.out.println("Contents of a1: " + a1);

        Integer ia[] = new Integer[a1.size()];
        ia = a1.toArray(ia);
        int sum = 0;
        for(int i : ia) {
            sum += i;
        }
        System.out.println("Sum is : " + sum);

        Object ib[] = new Integer[a1.size()];
        ib = a1.toArray();
        for(Object k : ib) {
            int j = (int)k;
            System.out.println(j);
        }
    }
}
