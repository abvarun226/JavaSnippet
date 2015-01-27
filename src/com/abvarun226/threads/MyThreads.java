package com.abvarun226.threads;

/**
 * Created by bharghav on 10/13/14.
 */

public class MyThreads extends Thread {

    @Override
    public void run() {

        int iterations = 5;

        try {
            for (int i = 0 ; i < iterations ; i++) {
                System.out.println("From Secondary thread : " + i);
                sleep(2000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
