package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/17/15.
 */

interface StringFunc1 {
    String func(String n);
}

class StringOps1 {
    public String strReverse(String myStr) {
        String result = "";
        for(int i=myStr.length()-1 ; i>=0 ; i--) result += myStr.charAt(i);
        return result;
    }
}

public class InstanceMethodRef1 {
    static String stringOps(StringFunc1 sf, String s) {
        return sf.func(s);
    }

    public static void main(String [] args) {
        String inStr = "A way to pass executable code as an argument to a method";
        String outStr;

        StringOps1 obj1 = new StringOps1();

        outStr = stringOps(obj1::strReverse, inStr);
        System.out.println("Original String: \n" + inStr + "\n");
        System.out.println("Reversed String: \n" + outStr);
    }
}
