package com.abvarun226.Concurrency;

import java.util.concurrent.*;

/**
 * Created by bharghav on 1/28/15.
 */

class MyThread4 implements Runnable {
    CountDownLatch latch;
    String name;

    MyThread4(CountDownLatch c, String n) {
        name = n;
        latch = c;
        new Thread(this);
    }

    @Override
    public void run() {
        for (int i=0 ; i<5 ; i++) {
            latch.countDown();
            System.out.println(name + " : " + i);
        }
    }
}
public class ExecutorDemo1 {
    public static void main(String... args) {
        CountDownLatch cdl1 = new CountDownLatch(5);
        CountDownLatch cdl2 = new CountDownLatch(5);
        CountDownLatch cdl3 = new CountDownLatch(5);
        CountDownLatch cdl4 = new CountDownLatch(5);
        ExecutorService es = Executors.newFixedThreadPool(2);

        System.out.println("Starting Demo.\n");

        es.execute(new MyThread4(cdl1, "A"));
        es.execute(new MyThread4(cdl2, "B"));
        es.execute(new MyThread4(cdl3, "C"));
        es.execute(new MyThread4(cdl4, "D"));

        try {
            cdl1.await();
            cdl2.await();
            cdl3.await();
            cdl4.await();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        es.shutdown();
        System.out.println("Completed.\n");
    }
}
