package com.abvarun226.NIODemo;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by bharghav on 1/29/15.
 */
public class StreamBasedIOWrite {
    public static void main(String... args) {

        try ( OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("test1.txt"))); ) {

            for (int i=0 ; i<26 ; i++) {
                fout.write((byte) ('A' + i));
            }
            fout.write('\n');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
