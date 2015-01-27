package com.abvarun226.MultiThreadedProgramming;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by bharghav on 1/22/15.
 */

class MyRunnable implements Runnable {
    private final String url;

    MyRunnable(String url) {
        this.url = url;
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
        System.out.println(url + "\t\tStatus : " + result);
    }
}
public class MultiThreadPingProgram {

    private static final int MYTHREADS = 30;

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

        ExecutorService executor = Executors.newFixedThreadPool(MYTHREADS);

        for(int i=0 ; i < hostList.length ; i++) {
            String url = hostList[i];
            MyRunnable worker = new MyRunnable(url);
            executor.execute(worker);
        }

        executor.shutdown();

        while(!executor.isTerminated()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Exception");
            }
        }
        System.out.println("\nFinished all Threads");
    }
}
