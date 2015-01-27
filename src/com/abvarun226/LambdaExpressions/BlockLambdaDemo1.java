package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/17/15.
 */

interface factorial {
    int compute(int n);
}

interface stringReverse {
    String doIt(String n);
}

public class BlockLambdaDemo1 {
    public static void main(String [] args) {

        factorial obj1 = (n) -> {
            int result = 1;

            for(int i=1 ; i<=n ; i++) {
                result = i * result;
            }

            return result;
        };

        int myVal = 5;
        System.out.println("Factorial of " + myVal + " is : " + obj1.compute(myVal));

        myVal = 6;
        System.out.println("Factorial of " + myVal + " is : " + obj1.compute(myVal));


        stringReverse obj2 = (myString) -> {
            String result = "";
            for(int i=myString.length()-1 ; i>=0 ; i--) {
                result += myString.charAt(i);
            }

            return result;
        };

        System.out.println();

        String myStr = "Lambda";
        System.out.println(myStr + "reversed is " + obj2.doIt(myStr));

        myStr = "Expression";
        System.out.println(myStr + "reversed is " + obj2.doIt(myStr));

    }
}
