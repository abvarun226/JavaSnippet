package com.abvarun226.ExceptionHandling;

/**
 * Created by bharghav on 1/15/15.
 */

public class ChainedException {
    static void demoproc() {
        NullPointerException e = new NullPointerException("Top Level Exception");

        e.initCause(new ArithmeticException("Demo Cause"));

        throw e;
    }

    public static void main(String... args) {
        try {
            demoproc();
        } catch(NullPointerException e) {
            System.out.println("Exception : " + e);
            System.out.println("Cause : " + e.getCause());
            //e.printStackTrace();
        }
    }
}
