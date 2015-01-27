package com.abvarun226.CollectionsDemo;

import java.util.*;

/**
 * Created by bharghav on 1/25/15.
 */

class MyComp1 implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        return bStr.compareTo(aStr);
    }
}

class MyComp2 implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        return aStr.compareTo(bStr);
    }
}

public class ComparatorsDemo {
    public static void main(String... args) {
        TreeSet<String> ts = new TreeSet<>(new MyComp1());
        ts.add("C");
        ts.add("D");
        ts.add("A");
        ts.add("B");
        ts.add("E");
        ts.add("F");

        for (String temp : ts) {
            System.out.print(temp + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Using reversed() method");
        TreeSet<String> ts2 = new TreeSet<>(new MyComp2().reversed());
        ts2.add("C");
        ts2.add("D");
        ts2.add("A");
        ts2.add("B");
        ts2.add("E");
        ts2.add("F");

        for (String temp : ts2) {
            System.out.print(temp + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Using lambda expression");
        //Comparator<String> mc = (aStr, bStr) -> aStr.compareTo(bStr);
        //TreeSet<String> ts3 = new TreeSet<>(mc.reversed());
        TreeSet<String> ts3 = new TreeSet<>((aStr, bStr) -> bStr.compareTo(aStr));
        ts3.add("C");
        ts3.add("D");
        ts3.add("A");
        ts3.add("B");
        ts3.add("E");
        ts3.add("F");
        for (String temp : ts3) {
            System.out.print(temp + " ");
        }
        System.out.println();


    }
}
