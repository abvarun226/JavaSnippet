package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 */

class GenCons {

    private double val;

    <T extends Number> GenCons(T arg) {
        val = arg.doubleValue();
    }

    void showVal() {
        System.out.println("Val : " + val);
    }
}

public class GenericConstructorDemo {
    public static void main(String[] args) {
        GenCons test = new GenCons(100);
        GenCons test1 = new GenCons(105.24F);
        GenCons test2 = new GenCons(105e-7);

        test.showVal();
        test1.showVal();
        test2.showVal();

    }
}
