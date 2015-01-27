package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/17/15.
 */

interface SomeFunc<T> {
    T func(T n);
}

public class GenericLambdaDemo1 {
    public static void main(String [] args) {

        SomeFunc<String> reverse = (n) -> {
            String result = "";
            for(int i=n.length()-1 ; i>=0 ; i--) {
                result += n.charAt(i);
            }
            return result;
        };

        SomeFunc<Integer> factorial = (n) -> {
            int result = 1;
            for(int i=1 ; i<=n ; i++) {
                result = i * result;
            }
            return result;
        };

        String myStr = "Hello";
        System.out.println(myStr + " reversed is " + reverse.func(myStr));
        myStr = "World";
        System.out.println(myStr + " reversed is " + reverse.func(myStr));

        System.out.println();

        int myVal = 5;
        System.out.println("Factorial of " + myVal + " : " + factorial.func(myVal));
        myVal = 10;
        System.out.println("Factorial of " + myVal + " : " + factorial.func(myVal));
    }
}
