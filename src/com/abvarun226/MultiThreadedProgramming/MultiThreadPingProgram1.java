package com.abvarun226.MultiThreadedProgramming;

import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by bharghav on 1/22/15.
 */

class MyRunnable1 implements Runnable {
    private final String url;
    private Thread t;
    private static int count = 0;
    private int threadNum;

    MyRunnable1(String url) {
        this.url = url;
        t = new Thread(this);
        //System.out.println("Starting thread " + ++count);
        threadNum = ++count;
        t.start();
    }

    @Override
    public void run() {

        String result = "";
        int code = 200;
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            connection.getResponseCode();
            if(code == 200) {
                result = "Green\t";
            }
        } catch (Exception e) {
            result = "### RED ###\t";
        }
        System.out.println(threadNum + "] " + url + "\t\tStatus : " + result);
    }
}
public class MultiThreadPingProgram1 {

    public static void main(String... args) {
        String[] hostList = { "http://crunchify.com", "http://yahoo.com",
                "http://www.ebay.com", "http://google.com",
                "http://www.example.co", "https://paypal.com",
                "http://bing.com/", "http://techcrunch.com/",
                "http://mashable.com/", "http://thenextweb.com/",
                "http://wordpress.com/", "http://wordpress.org/",
                "http://example.com/", "http://sjsu.edu/",
                "http://ebay.co.uk/", "http://google.co.uk/",
                "http://www.wikipedia.org/",
                "http://en.wikipedia.org/wiki/Main_Page" };


        for(int i=0 ; i < hostList.length ; i++) {
            String url = hostList[i];
            MyRunnable1 worker = new MyRunnable1(url);
        }

        System.out.println("\nFinished all Threads");
    }
}
