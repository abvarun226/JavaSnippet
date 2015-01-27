package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class MultiThread1 implements Runnable {
    String name;
    Thread t;
    long sleepTime;

    MultiThread1(String threadName, long threadSleepTime) {
        name = threadName;
        sleepTime = threadSleepTime;
        t = new Thread(this, name);
        System.out.println("[" + new java.util.Date().getTime() + "] Child Thread : " + t);
        t.start();
    }

    public void run() {
        try {
            for(int n=5 ; n>0 ; n--) {
                System.out.println("Child thread " + name + " : " + n);
                Thread.sleep(sleepTime);
            }
        } catch(InterruptedException e) {
            System.out.println("Child Thread " + name + " : " + e);
        }

        System.out.println("Exiting Child Thread " + name);
    }
}

public class DemoThreadJoin {
    public static void main(String... args) {
        MultiThread1 thread1 = new MultiThread1("one", 3000);
        MultiThread1 thread2 = new MultiThread1("two", 2000);
        MultiThread1 thread3 = new MultiThread1("three", 1000);

        System.out.println("Thread one is alive : " + thread1.t.isAlive());
        System.out.println("Thread two is alive : " + thread2.t.isAlive());
        System.out.println("Thread three is alive : " + thread3.t.isAlive());

        try {
            System.out.println("Waiting for child threads to complete!");
            thread3.t.join();
            System.out.println("Waiting for thread three to finish!");
            thread1.t.join();
            System.out.println("Waiting for thread one to finish!");
            thread2.t.join();
            System.out.println("Waiting for thread two to finish!");

        } catch(InterruptedException e) {
            System.out.println("Main Thread Interrupted : " + e);
        }

        System.out.println("Thread one is alive : " + thread1.t.isAlive());
        System.out.println("Thread two is alive : " + thread2.t.isAlive());
        System.out.println("Thread three is alive : " + thread3.t.isAlive());

        System.out.println("Exiting Main Thread.");
    }
}
