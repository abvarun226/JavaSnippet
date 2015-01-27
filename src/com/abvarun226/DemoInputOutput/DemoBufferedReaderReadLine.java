package com.abvarun226.DemoInputOutput;

import java.io.*;

/**
 * Created by bharghav on 1/16/15.
 */
public class DemoBufferedReaderReadLine {
    public static void main(String... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the lines of text.");
        System.out.println("Enter 'stop' to quit.");

        String str;
        do {
            str = br.readLine();
            System.out.println(str);
        } while(!str.equals("stop"));
    }
}
