package com.abvarun226.CollectionsDemo;

import java.util.*;

/**
 * Created by bharghav on 1/24/15.
 *
 * Spliterator Demo with tryAdvance and forEachRemaining
 * Iterator Demo with forEachRemaining
 * RandomAccess check for collections
 *
 */

public class SpliteratorDemo1 {
    public static void main(String... args) {
        ArrayList<Double> vals = new ArrayList<>();
        vals.add(1.0);
        vals.add(2.0);
        vals.add(3.0);
        vals.add(4.0);
        vals.add(5.0);

        System.out.println("Contents of vals:\n");
        Spliterator<Double> splitr = vals.spliterator();
        while (splitr.tryAdvance((n) -> System.out.println(n)));
        System.out.println();

        splitr = vals.spliterator();
        System.out.println("Characteristics: " + splitr.characteristics());

        ArrayList<Double> sqrs = new ArrayList<>();
        while (splitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))));
        System.out.println("Contents of sqrs:\n");
        splitr = sqrs.spliterator();
        splitr.forEachRemaining((n) -> System.out.println(n));
        System.out.println();

        // forEachRemaining() with Iterator interface
        Iterator<Double> itr = vals.iterator();
        itr.forEachRemaining((n) -> System.out.println(n*n));

        System.out.println();

        // Check if specific collections supports RandomAccess
        if(vals instanceof RandomAccess) {
            System.out.println("vals supports RandomAccess");
        }
        LinkedList<Double> ll1 = new LinkedList<>();
        if(ll1 instanceof RandomAccess) {
            System.out.println("ll1 supports RandomAccess");
        } else {
            System.out.println("ll1 does not support RandomAccess");
        }
    }
}
