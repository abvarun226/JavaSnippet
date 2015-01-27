package com.abvarun226.CollectionsDemo;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by bharghav on 1/25/15.
 */

// Sort by last name
class CompLastNames implements Comparator<String> {
    @Override
    public int compare(String aStr, String bStr) {
        int i ,j;
        i = aStr.indexOf(' ');
        j = bStr.indexOf(' ');

        return aStr.substring(i).compareToIgnoreCase(bStr.substring(j));

    }
}

// Sort by entire name when last names are equal
class CompThenByFirstName implements Comparator<String> {

    @Override
    public int compare(String aStr, String bStr) {
        int i,j;
        return aStr.compareToIgnoreCase(bStr);
    }
}

public class ComparatorThenComparingDemo {
    public static void main(String... args) {
//        CompLastNames compLN = new CompLastNames();
//        Comparator<String> compLastThenFirst = compLN.thenComparing(new CompThenByFirstName());

        Comparator<String> compLN = (aStr, bStr) -> aStr.substring(aStr.indexOf(' ')).compareToIgnoreCase(bStr.substring(bStr.indexOf(' ')));
        Comparator<String> compLastThenFirst = compLN.thenComparing((aStr,bStr) -> aStr.compareToIgnoreCase(bStr));

        TreeMap<String,Double> tm = new TreeMap<>(compLastThenFirst);
        tm.put("John Doe", new Double(3434.34));
        tm.put("Tom Smith", new Double(123.22));
        tm.put("Jane Baker", new Double(1378.00));
        tm.put("Tod Hall", new Double(99.22));
        tm.put("Ralph Smith", new Double(-19.08));

        for (Map.Entry<String,Double> temp : tm.entrySet()) {
            System.out.println(temp.getKey() + " : " + temp.getValue());
        }

        System.out.println();

        tm.put("John Doe", tm.get("John Doe") + 1000.00);
        System.out.println("John Doe's new balance : " + tm.get("John Doe"));
        System.out.println();

    }
}
