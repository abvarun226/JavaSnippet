package com.abvarun226.DemoInputOutput;

import java.io.*;

/**
 * Created by bharghav on 1/16/15.
 */
public class DemoCopyFile1 {
    public static void main(String... args) {
        FileInputStream fin = null;
        FileOutputStream fout = null;

        int i;

        try {
            fin = new FileInputStream("/Users/bharghav/drm_test1-TRANSCODE-COMPLETE_d.xml");
            fout = new FileOutputStream("/Users/bharghav/temp1.xml");
            i = fin.read();
            while(i != -1) {
                fout.write(i);
                i = fin.read();
            }
            System.out.println("Successfully copied file!");
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
            } catch (IOException e) {
                System.out.println("IOException when closing input file!");
            }
            try {
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                System.out.println("IOException when closing output file!");
            }
        }
    }
}
