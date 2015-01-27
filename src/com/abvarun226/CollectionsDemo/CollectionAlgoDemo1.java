package com.abvarun226.CollectionsDemo;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Created by bharghav on 1/25/15.
 */
public class CollectionAlgoDemo1 {
    public static void main(String... args) {
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(-8);
        l1.add(20);
        l1.add(-20);
        l1.add(8);

        Comparator<Integer> r = Collections.reverseOrder();
        Collections.sort(l1, r);
        System.out.println("List sorted in reverse order: ");
        for (int i : l1) {
            System.out.println(i + " ");
        }

        System.out.println();

        Collections.shuffle(l1);
        System.out.println("list shuffled: ");
        for (int i : l1) {
            System.out.println(i + " ");
        }

        System.out.println();
        System.out.println("Minimum: " + Collections.min(l1));
        System.out.println("Maximum: " + Collections.max(l1));

    }
}
