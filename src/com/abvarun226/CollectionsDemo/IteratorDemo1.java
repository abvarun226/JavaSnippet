package com.abvarun226.CollectionsDemo;

import java.util.*;

/**
 * Created by bharghav on 1/23/15.
 */
public class IteratorDemo1 {
    public static void main(String... args) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        a1.add(4);
        a1.add(5);

        ListIterator<Integer> iterator = a1.listIterator();
        while(iterator.hasNext()) {
            Integer temp = iterator.next();
            System.out.println("Temp : " + temp);
            if(temp == 5) {
                iterator.add(6);
            }
        }
        System.out.println();
        System.out.println(a1);
        System.out.println();

        while(iterator.hasNext()) {
            iterator.next(); // never executed because iterator is at end of the list already
            System.out.println("Hello");
        }

        while(iterator.hasPrevious()) {
            Integer temp = iterator.previous();
            System.out.println("Temp : " + temp);

            if(temp == 1) {
                iterator.remove();
                iterator.add(0);
                // iterator.remove();  // Throws IllegalStateException since it is not preceded by a call next() or previous()
            }
        }
        System.out.println();
        System.out.println(a1);

    }
}
