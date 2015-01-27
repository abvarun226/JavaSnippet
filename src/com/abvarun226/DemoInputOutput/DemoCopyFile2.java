package com.abvarun226.DemoInputOutput;

import java.io.*;

/**
 * Created by bharghav on 1/16/15.
 */
public class DemoCopyFile2 {
    public static void main(String... args) {
        int i;

        try (
                FileInputStream fin = new FileInputStream("/Users/bharghav/drm_test1-TRANSCODE-COMPLETE_d.xml");
                FileOutputStream fout = new FileOutputStream("/Users/bharghav/temp1.xml");
        ) {
            i = fin.read();
            while(i!=-1) {
                fout.write(i);
                i = fin.read();
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            System.out.println("IOException : " + e);
        }
    }
}
