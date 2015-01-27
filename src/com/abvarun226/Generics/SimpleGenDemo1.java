package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 */

class Gen<T> {
    T ob;

    Gen(T o) {
        ob = o;
    }

    T getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class SimpleGenDemo1 {
    public static void main(String[] args) {
        Gen<Integer> iob;

        iob = new Gen<Integer>(88);

        iob.showType();

        int v = iob.getOb();
        System.out.println("Value of iob = " + v);

        System.out.println();

        Gen<String> strob = new Gen<>("Generics Test");

        strob.showType();

        String w = strob.getOb();
        System.out.println("Value of strob = " + w);

    }
}
