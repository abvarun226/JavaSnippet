package com.abvarun226.StringOps;

/**
 * Created by bharghav on 1/9/15.
 */
public class StringMatch {
    public static void main(String args[]) {
        String[] myString = {"", "12345", "ABcd", "abcd", "ABCD", "ab12"};
        for(String a : myString) {
            System.out.println("Alphabets present : " + a.matches(".*[A-Za-z].*"));
        }
    }
}
