package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class NewThread1 extends Thread {

    NewThread1() {
        super("New My Thread");
        System.out.println("Child Thread: " + this);
        start();
    }

    public void run() {
        try {
            for(int n=5 ; n>0 ; n--) {
                System.out.println("Child Thread : " + n);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted : " + e);
        }

        System.out.println("Exiting Child Thread");
    }
}

public class DemoThreadClass {
    public static void main(String... args) {
        new NewThread1();

        try {
            for(int n=5 ; n>0 ; n--) {
                System.out.println("Main Thread : " + n);
                Thread.sleep(1500);
            }
        } catch(InterruptedException e) {
            System.out.println("Main Interrupted : " + e);
        }

        System.out.println("Exiting Main Thread");
    }
}
