package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 */

public class GenericMethodDemo1 {
    static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
        for(int i=0 ; i<y.length ; i++) {
            if(x.equals(y[i])) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Integer inums[] = {1,2,3,4,5};

        if(isIn(2, inums)) {
            System.out.println("2 is in inums");
        }

        if(!isIn(7, inums)) {
            System.out.println("7 is not in inums");
        }

        System.out.println();

        String strs[] = {"one", "two", "three", "four", "five"};

        if(isIn("three", strs)) {
            System.out.println("three is in strs");
        }

        if(!isIn("seven", strs)) {
            System.out.println("seven is not in strs");
        }

        System.out.println();

        // This wont compile
//        if(isIn(2, strs)) {
//            System.out.println("2 is in strs");
//        }
    }
}
