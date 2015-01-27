package com.abvarun226.JavaLangDemo;

/**
 * Created by bharghav on 1/21/15.
 */
public class MathDemo1 {
    public static void main(String... args) {

        System.out.println("abs: " + Math.abs(new Double(-10.15)));
        System.out.println("abs: " + Math.abs(new Float(-10.15)));
        System.out.println("ceil: " + Math.ceil(new Double(-10.15)));
        System.out.println("floor: " + Math.floor(new Double(-10.55)));
        System.out.println("ceil: " + Math.ceil(new Double(10.15)));
        System.out.println("floor: " + Math.floor(new Double(10.55)));
        System.out.println("nextAfter: " + Math.nextAfter(new Double(10.00), new Double(11.0)));
        System.out.println("nextDown: " + Math.nextDown(new Double(10.0)));
        System.out.println("nextUp: " + Math.nextUp(new Double(10.0)));
        System.out.println("nextAfter: " + Math.ulp(new Double(10.00)));
        System.out.println("addExact: " + Math.addExact(13L, 11L));
        System.out.println("copySign: " + Math.copySign(13.12, -15.0));
        System.out.println("getExponent: " + Math.getExponent(13.12));
        System.out.println("toDegrees: " + Math.toDegrees(Math.PI));
        System.out.println("toIntExact: " + Math.toIntExact(40000L));
        // System.out.println("toIntExact: " + Math.toIntExact(4000000000L * 1000000000L)); // Integer overflow

    }
}
