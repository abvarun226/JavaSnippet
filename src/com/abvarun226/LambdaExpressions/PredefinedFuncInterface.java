package com.abvarun226.LambdaExpressions;

import java.util.function.Function; // new in jdk 8

/**
 *
 * Created by bharghav on 1/18/15.
 *
 * Predefined Functional Interface
 *
 * Usage:
 * Function<T,R>
 *     Apply an operation to an object of type T and return the result as an object of type R
 *     Its method is called apply()
 *
 */

public class PredefinedFuncInterface {
    public static void main(String... args) {
        Function<Integer, Integer> factorial = (n) -> {
            int result = 1;
            for(int i=1 ; i<=n ; i++) {
                result = i * result;
            }
            return result;
        };
        System.out.println("Factorial of 5 is : " + factorial.apply(5));
        System.out.println("Factorial of 8 is : " + factorial.apply(8));
    }
}
