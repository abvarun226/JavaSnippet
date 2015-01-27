package com.abvarun226.MultiThreadedProgramming;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by bharghav on 1/15/15.
 */

class NewThread implements Runnable {
    Thread t;

    NewThread() {
        t = new Thread(this, "Demo Thread");
        System.out.println("Child Thread : " + t);
        t.start();
    }

    public void run() {
        try {
            for(int n=5 ; n>0 ; n--) {
                System.out.println("Child Thread : " + n);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.out.println("Child Interrupted" + e.getMessage());
        }
        System.out.println("Exiting Child Thread");
    }
}

public class DemoRunnableInterface {
    public static void main(String[] args) {
        NewThread threadObj = new NewThread();

        try {
            for(int n=5 ; n>0 ; n--) {
                System.out.println("Main Thread : " + n);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("Main Interrupted : " + e.getMessage() );
        }

        System.out.println("Waiting for Child Thread to complete!");

        try {
            threadObj.t.join(); // Main Thread waits for Child Thread ( threadObj.t ) to complete before subsequent code is executed in this thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Exiting Main Thread");
    }

}
