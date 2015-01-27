package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/17/15.
 */

interface StringFunc {
    String func(String n);
}

class StringOps {
    static String strReverse(String inStr) {
        String result = "";
        for(int i=inStr.length()-1 ; i>=0 ; i--) {
            result += inStr.charAt(i);
        }
        return result;
    }
}

public class StaticMethodRef1 {
    static String stringOps(StringFunc sf, String s) {
        return sf.func(s);
    }

    public static void main(String [] args) {
        String inStr = "A way to pass executable code as an argument to a method";
        String outStr;

        outStr = stringOps(StringOps::strReverse, inStr);
        System.out.println("Original String: \n" + inStr + "\n");
        System.out.println("Reversed String: \n" + outStr);
    }
}
