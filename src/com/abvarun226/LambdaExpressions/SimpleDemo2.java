package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/17/15.
 */

interface ParamTest1 {
    boolean test(int n);
}

interface ParamTest2 {
    boolean test(int n,int m);
}

public class SimpleDemo2 {
    public static void main(String[] args) {
        ParamTest1 isEven = (n) -> (n%2) == 0;

        int myVal = 12;
        System.out.println("Is " + myVal + " even? " + isEven.test(myVal));

        myVal = 11;
        System.out.println("Is " + myVal + " even? " + isEven.test(myVal));

        ParamTest1 nonNegative = (int n) -> n < 0;

        myVal = -1;
        System.out.println("Is " + myVal + " negative? " + nonNegative.test(myVal));

        myVal = 1;
        System.out.println("Is " + myVal + " negative? " + nonNegative.test(myVal));

        ParamTest2 isFactor = (n, m) -> (n % m) == 0;

        int n1=4 ,m1 = 2;
        System.out.println("Is " + m1 + " a factor of " + n1 + "? " + isFactor.test(n1, m1));

        n1 = 5 ; m1 = 2;
        System.out.println("Is " + m1 + " a factor of " + n1 + "? " + isFactor.test(n1, m1));

    }
}
