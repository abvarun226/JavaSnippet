package com.abvarun226.Concurrency;

import java.util.concurrent.CountDownLatch;

/**
 * Created by bharghav on 1/27/15.
 */

class MyThread implements Runnable {
    CountDownLatch latch;

    MyThread(CountDownLatch cdl) {
        latch = cdl;

        System.out.println("Thread created");
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            for (int i=0 ; i<5 ; i++) {
                System.out.println("i = " + i);
                latch.countDown();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

public class CountDownLatchDemo {
    public static void main(String... args) {
        CountDownLatch cdl = new CountDownLatch(5);

        MyThread th = new MyThread(cdl);

        try {
            cdl.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Execution Complete.");
    }
}
