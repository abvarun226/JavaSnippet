package com.abvarun226.NetworkingDemo;

import java.net.URL;

/**
 * Created by bharghav on 1/30/15.
 */
public class URLDemo {
    public static void main(String... args) throws  Exception {
        URL hp = new URL("https://screen.yahoo.com/snl/");

        System.out.println("Protocol: " + hp.getProtocol());
        System.out.println("Host    : " + hp.getHost());
        System.out.println("Port    : " + hp.getPort());
        System.out.println("File    : " + hp.getFile());
        System.out.println("Ext     : " + hp.toExternalForm());
    }
}
