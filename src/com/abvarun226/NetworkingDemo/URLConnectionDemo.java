package com.abvarun226.NetworkingDemo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

/**
 * Created by bharghav on 1/30/15.
 */
public class URLConnectionDemo {
    public static void main(String... args) throws Exception {
        URL hp = new URL("https://us.yahoo.com");
        URLConnection hpCon = hp.openConnection();

        long d = hpCon.getDate();
        if(d == 0) {
            System.out.println("No date information");
        } else {
            System.out.println("Date: " + new Date(d));
        }

        System.out.println("Content-type: " + hpCon.getContentType());

        d = hpCon.getExpiration();
        if(d == 0) {
            System.out.println("No expiration information");
        } else {
            System.out.println("Expiration: " + hpCon.getExpiration());
        }

        d = hpCon.getLastModified();
        if(d == 0) {
            System.out.println("No last-modified information");
        } else {
            System.out.println("Last-Modified: " + hpCon.getLastModified());
        }

        long len = hpCon.getContentLength();
        if(len == -1) {
            System.out.println("Content Length unavailable");
        } else {
            System.out.println("Content-Length: " + len);
        }

        int c;
        if(len != 0) {
            System.out.println("==== Content ====");
            InputStream input = hpCon.getInputStream();

            while ((c = input.read()) != -1) {
                System.out.print((char) c);
            }
            input.close();
        } else {
            System.out.println("No content available");
        }
    }
}
