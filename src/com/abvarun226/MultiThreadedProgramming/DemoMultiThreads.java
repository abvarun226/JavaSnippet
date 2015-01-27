package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class MultiThread implements Runnable {
    String name;
    Thread t;

    MultiThread(String threadName) {
        name = threadName;
        t = new Thread(this, name);
        System.out.println("[" + new java.util.Date().getTime() + "] Child Thread : " + t);
        t.start();
    }

    public void run() {
        try {
            for(int n=5 ; n>0 ; n--) {
                System.out.println("[" + new java.util.Date().getTime() + "] Thread " + name + " : " + n);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("Thread " + name + " Interrupted : " + e);
        }
        System.out.println("Exiting Thread " + name);
    }
}

public class DemoMultiThreads {
    public static void main(String... args) {
        new MultiThread("one");
        new MultiThread("two");
        new MultiThread("three");

        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) {
            System.out.println("Main Thread interrupted : " + e);
        }

        System.out.println("Exiting Main Thread");
    }
}
