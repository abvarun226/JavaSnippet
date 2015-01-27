package com.abvarun226.DemoInputOutput;

import java.io.*;

/**
 * Created by bharghav on 1/16/15.
 */
public class DemoPrintWriter {
    public static void main(String... args) {
        PrintWriter pw = new PrintWriter(System.out, true);

        pw.println("This is a string");

        int i = -7;
        pw.println(i);

        double d = 4.5e-7;
        pw.println(d);
    }
}
