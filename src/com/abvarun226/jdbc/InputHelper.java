package com.abvarun226.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by bharghav on 10/20/14.
 */

public class InputHelper {

    public static String getInput(String prompt) {
        BufferedReader stdin = new BufferedReader(
                new InputStreamReader(System.in)
        );

        System.out.println(prompt);
        System.out.flush();

        try {
            return stdin.readLine();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

    public static int getInputInteger(String prompt) throws NumberFormatException {
        String input = getInput(prompt);
        return Integer.parseInt(input);
    }
}
