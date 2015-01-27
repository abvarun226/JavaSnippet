package com.abvarun226.DemoInputOutput;

import java.io.*;

/**
 * Created by bharghav on 1/16/15.
 */
public class DemoBufferedReader {
    public static void main(String... args) throws IOException {
        char c;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter characters, 'q' to Quit.");

        do {
            c = (char) br.read();
            System.out.println(c);
        } while(c != 'q');
    }
}
