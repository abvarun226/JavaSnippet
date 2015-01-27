package com.abvarun226.ExceptionHandling;

import java.util.Random;

/**
 * Created by bharghav on 1/15/15.
 */
public class MultiCatch {
    public static void main (String... args) {
        int a=10 , b=0;
        int[] vals = {1,2,3};

        Random rn = new Random();
        b = rn.nextInt(2);

        try {

            System.out.print("Result of " + a + "/" + b + " = ");
            System.out.println(a/b); // ArithmeticException

            vals[10] = 19; // ArrayOutOfBoundsException

        } catch(ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("[Exception : " + e + "]");
        }

        System.out.println("After multi-catch.");
    }
}
