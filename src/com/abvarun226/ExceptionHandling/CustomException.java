package com.abvarun226.ExceptionHandling;

/**
 * Created by bharghav on 1/15/15.
 */

class MyException extends Exception { // MyException is a subclass of Exception class
    private int detail;

    MyException(int a) {
        detail = a;
    }

    public String toString() { // Override default toString() method to display custom message
        return "MyException[" + detail + "]";
    }
}

public class CustomException {
    static void compute(int a) throws MyException { // MyException is not an Error or RunTimeException or any of its subclasses. So need to include "throws" clause
        System.out.println("Called compute(" + a + ");");
        if(a > 10) {
            throw new MyException(a);
        }
        System.out.println("Exit normally!");
    }
    public static void main(String... args) {
        try {
            compute(5);
            compute(11);
        } catch(MyException e) {
            System.out.println("Caught exception : " + e);
        }
    }
}
