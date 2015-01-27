package com.abvarun226.threadsRunnable;

/**
 * Created by bharghav on 10/13/14.
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        int iterations = 5;

        try {
            for(int i=0 ; i<iterations ; i++) {
                System.out.println("From Runnable : " + i);
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
