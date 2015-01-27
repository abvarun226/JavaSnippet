package com.abvarun226.CollectionsDemo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bharghav on 1/25/15.
 */

class TComp implements Comparator<String> {
    @Override
    public int compare(String aStr, String bStr) {
        int i, j, k;
        i = aStr.indexOf(' ');
        j = bStr.indexOf(' ');
        k = aStr.substring(i).compareToIgnoreCase(bStr.substring(j));

        if (k == 0)
            return aStr.compareToIgnoreCase(bStr);
        else
            return k;
    }
}

public class ComparatorDemo2 {

    public static void main(String... args) {
        TreeMap<String,Double> tm = new TreeMap<>(new TComp());
        tm.put("John Doe", new Double(3434.34));
        tm.put("Tom Smith", new Double(123.22));
        tm.put("Jane Baker", new Double(1378.00));
        tm.put("Tod Hall", new Double(99.22));
        tm.put("Ralph Smith", new Double(-19.08));

        for (Map.Entry<String,Double> temp : tm.entrySet()) {
            System.out.println(temp.getKey() + " : " + temp.getValue());
        }
        System.out.println();
        tm.put("John Doe", tm.get("John Doe") + 1000);
        System.out.println("John Doe's new balance : " + tm.get("John Doe"));
        System.out.println();
    }
}
