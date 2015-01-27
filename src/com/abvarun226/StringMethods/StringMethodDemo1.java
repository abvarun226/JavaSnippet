package com.abvarun226.StringMethods;

/**
 * Created by bharghav on 1/19/15.
 */
public class StringMethodDemo1 {
    public static void main(String... args) {
        StringBuffer str1 = new StringBuffer("abcdef");

        System.out.println(str1);
        str1.reverse();
        System.out.println(str1);

        str1.deleteCharAt(2);
        System.out.println(str1);
        str1.delete(2,5);
        System.out.println(str1);

        str1.replace(0, 2, "abcdef");
        System.out.println(str1);

        String temp = str1.substring(3);
        System.out.println(temp);
        temp = str1.substring(0,3);
        System.out.println(temp);

        Character ch = new Character('A');
        System.out.println("Width of char in bytes : " + ch.BYTES);
        System.out.println("MAX_RADIX of char      : " + ch.MAX_RADIX);
        System.out.println("MIN_RADIX of char      : " + ch.MIN_RADIX);
        System.out.println("MAX_VALUE of char      : " + ch.MAX_VALUE);
        System.out.println("MIN_VALUE of char      : " + ch.MIN_VALUE);
        System.out.println("TYPE of char           : " + ch.TYPE);

        int i1 = 14;
        System.out.println("Digit character : " + Character.forDigit(i1,10));

    }
}
