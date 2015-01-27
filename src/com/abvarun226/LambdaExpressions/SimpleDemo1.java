package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/17/15.
 */

interface MyNumber {
    double myValue();
}

public class SimpleDemo1 {
    public static void main(String[] args) {
        MyNumber myNum;

        myNum = () -> 123.45;
        System.out.println("Value is " + myNum.myValue());

        myNum = () -> Math.random() * 100;
        System.out.println("1. Random value is " + myNum.myValue());
        System.out.println("2. Random value is " + myNum.myValue());

//        myNum = () -> "123.45";
    }
}
