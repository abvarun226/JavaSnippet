package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 */

class TwoGen<T, V> {
    T ob1;
    V ob2;

    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    T getOb1() {
        return ob1;
    }

    V getOb2() {
        return ob2;
    }

    void showTypes() {
        System.out.println("The type of T is : " + ob1.getClass().getName());
        System.out.println("The type of V is : " + ob2.getClass().getName());
    }
}

public class TwoGenDemo1 {
    public static void main(String[] args) {
        TwoGen<Integer, String> obj1 = new TwoGen<>(101, "Two Gen Test");
        obj1.showTypes();
        int v = obj1.getOb1();
        String w = obj1.getOb2();

        System.out.println("Value of ob1 : " + v + " and value of ob2 : " + w);

        System.out.println();
    }
}
