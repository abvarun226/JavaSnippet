package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 */

class NonGeneric {
    Object ob;

    NonGeneric(Object o) {
        ob = o;
    }

    Object getOb() {
        return ob;
    }

    void showType() {
        System.out.println("Type of T is " + ob.getClass().getName());
    }
}

public class NonGenericGen1 {
    public static void main(String... args) {
        NonGeneric iob = new NonGeneric(89);
        iob.showType();
        int v = (Integer) iob.getOb();
        System.out.println("Value of iob = " + v);

        System.out.println();

        NonGeneric strob = new NonGeneric("NonGeneric Test");
        strob.showType();
        String w = (String) strob.getOb();
        System.out.println("Value of strob = " + w);

        // But this implementation does not prevent me from doing this,
        // iob = strob; // This will compile fine, but will throw run-time exception
        // v = (Integer) iob.getOb(); // This will compile fine, but will throw run-time exception
    }
}
