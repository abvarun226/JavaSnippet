package com.abvarun226.NIODemo;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by bharghav on 1/29/15.
 */
public class StreamBasedIORead {
    public static void main(String... args) {
        int i;

        try (InputStream fin = Files.newInputStream(Paths.get("/Users/bharghav/tools/bigxml.xml")); ) {

            do {

                i = fin.read();
                if (i != -1) System.out.print((char) i);

            } while(i != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
