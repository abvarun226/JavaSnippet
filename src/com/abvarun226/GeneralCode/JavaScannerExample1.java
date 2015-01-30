package com.abvarun226.GeneralCode;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by bharghav on 1/29/15.
 */
public class JavaScannerExample1 {
    public static void main(String... args) {
        int a,b,result;
        Scanner input = new Scanner(System.in);
        System.out.println("Input two integers:");
        try {
            a = input.nextInt();
            b = input.nextInt();
            result = a/b;
        } catch (InputMismatchException e) {
            System.out.println(e);
            return;
        } catch (Exception e) {
            System.out.println(e);
            return;
        }

        System.out.println("Result = " + result);

    }
}
