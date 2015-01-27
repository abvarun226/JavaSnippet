package com.abvarun226.threads;

/**
 * Created by bharghav on 10/13/14.
 */

public class Main {

    public static void main(String[] args) {

        int iterations = 3;
        MyThreads threads = new MyThreads();
        threads.start();

        try {
            for(int i = 0; i < iterations ; i++) {
                System.out.println("From Primary thread : " + i);
                threads.sleep(3000);
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }

    }
}
