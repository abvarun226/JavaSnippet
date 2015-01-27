package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 *
 * 1. Use of Bounded Types
 * 2. Use of WildCard argument
 *
 */

class Stats1<T extends Number> {
    T[] nums;

    Stats1(T[] a) {
        nums = a;
    }

    double average() {
        double sum = 0.0;

        for(int i=0 ; i<nums.length ; i++) {
            sum += nums[i].doubleValue();
        }

        return sum/nums.length;
    }

    boolean sameAvg1(Stats1<T> ob) {
        if(average() == ob.average()) {
            return true;
        }
        return false;
    }

    boolean sameAvg2(Stats1<?> ob) {
        if(average() == ob.average()) {
            return true;
        }
        return false;
    }
}

public class DemoBoundedTypes1 {
    public static void main(String[] args) {
        Integer[] inums = {1 , 2, 3, 4, 5};
        Stats1<Integer> iStats = new Stats1<>(inums);
        System.out.println("Average of inums = " + iStats.average());

        System.out.println();

        Double[] dnums = {1.5, 2.4, 3.3, 4.2, 5.1};
        Stats1<Double> dStats = new Stats1<Double>(dnums);
        System.out.println("Average of dnums = " + dStats.average());

        System.out.println();

        // This wont work. type parameter of invoking object must be same as the object passed as argument when using sameAvg1()
        // System.out.println("Is avg(inums) == avg(dnums)? " + iStats.sameAvg1(dStats));

        // This will work. type parameter of invoking object can be different from object passed as argument when using sameAvg2()
        System.out.println("Is avg(inums) == avg(dnums)? " + iStats.sameAvg2(dStats));
    }
}
