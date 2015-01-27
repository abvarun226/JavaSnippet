package com.abvarun226.training;

import java.util.HashSet;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        HashSet<String> set = new HashSet<String>();
        set.add("hello");
        set.add("world");
        set.add("Welcome");

        System.out.println(set.size());

        set.add("Welcome");

        System.out.println(set.size());

        set.add(null);

        System.out.println(set.size());

        for(String a : set) {
           System.out.println("Element : " + a);
        }

        TreeSet<String> tset = new TreeSet<String>();
        tset.add("hello");
        tset.add("world");
        tset.add("Welcome");
        tset.add("welcome");

        for(String a : tset) {
            System.out.println("tset Element : " + a);
        }
    }
}
