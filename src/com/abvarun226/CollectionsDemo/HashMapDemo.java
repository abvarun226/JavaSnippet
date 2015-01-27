package com.abvarun226.CollectionsDemo;

import java.util.*;

/**
 * Created by bharghav on 1/25/15.
 */
public class HashMapDemo {
    public static void main(String... args) {
        HashMap<String, Double> map1 = new HashMap<>();

        map1.put("Client1", new Double(1.1));
        map1.put("Client2", new Double(2.2));
        map1.put("Client3", new Double(3.3));

        Set<Map.Entry<String,Double>> set1 = map1.entrySet();
        for(Map.Entry<String,Double> itr : set1) {
            System.out.println(itr.getKey() + " | " + itr.getValue());
        }

        map1.put("Client1", map1.get("Client1") + 10.0);
        map1.computeIfAbsent("Client4", (n) -> 10.1);
        System.out.println();
        for(Map.Entry<String, Double> itr : map1.entrySet()) {
            System.out.println(itr.getKey() + " || " + itr.getValue());
        }


    }
}
