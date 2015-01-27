package com.abvarun226.threadsRunnable;

/**
 * Created by bharghav on 10/13/14.
 */
public class Main {
    public static void main(String[] args) {

        int iterations = 5;

        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();

        try {
            for(int i=0 ; i<iterations ; i++) {
                System.out.println("From Main thread : " + i);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
