package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/17/15.
 */

interface SomeFunc1 {
    String func(String n);
}

public class LambdaAsArgDemo1 {
    static String stringOp (SomeFunc1 sf, String s) {
        return sf.func(s);
    }

    public static void main(String [] args) {

        String inStr = "A way to pass executable code as an argument to a method";
        String outStr;

        int num = 5;  // effectively final! Variable Capture!! Demo
        // num = 6;  // Removing the comment from this line causes compile time error since "num" will lose its effectively final status!

        System.out.println("Original String : \n-----------------\n" + inStr);

        System.out.println();

        System.out.println("After converting to uppercase : \n-------------------------------\n" +
                stringOp( (myStr) -> myStr.toUpperCase() , inStr) );  // Lambda expression

        outStr = stringOp( (myStr) -> { // Lambda expression
            String result = "";

            int n = num + 10; // effectively final! Variable Capture!! Demo

            for(int i=0 ; i<myStr.length() ; i++) {
                if(myStr.charAt(i) != ' ') {
                    result += myStr.charAt(i);
                }
            }
            return result;
        } , inStr);

        System.out.println();
        System.out.println("After removing whitespace : \n---------------------------\n" + outStr);

        SomeFunc1 reverse = (myStr) -> { // Lambda Expression
            String result = "";
            for(int i=myStr.length()-1 ; i>=0 ; i--) {
                result += myStr.charAt(i);
            }
            return result;
        };

        System.out.println();
        System.out.println("After reversing the String : \n----------------------------\n" +
                stringOp(reverse, inStr)); // Passing reference of Lambda Expression as argument

    }
}
