package com.abvarun226.DemoInputOutput;

import java.io.*;

/**
 * Created by bharghav on 1/16/15.
 */
public class DemoFileIO1 {
    public static void main(String... args) {
        int i;
        FileInputStream fin;

        try {
            fin = new FileInputStream("/Users/bharghav/drm_test1-TRANSCODE-COMPLETE_d.xml");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            return;
        }

        try {
            i = fin.read();
            while(i != -1) {
                System.out.println((char)i);
                i = fin.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fin.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
