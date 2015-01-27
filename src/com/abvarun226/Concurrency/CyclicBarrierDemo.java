package com.abvarun226.Concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by bharghav on 1/27/15.
 */

class MyThread1 implements Runnable {
    CyclicBarrier cb;
    String name;

    MyThread1(CyclicBarrier cb, String n) {
        this.cb = cb;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println(name);

        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            System.out.println(e);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class BarAction implements Runnable {
    @Override
    public void run() {
        System.out.println("Barrier Reached!");
    }
}

public class CyclicBarrierDemo {
    public static void main(String... args) {
        CyclicBarrier cb = new CyclicBarrier(3, new BarAction());

        System.out.println("Starting");

        new MyThread1(cb, "A");
        new MyThread1(cb, "B");
        new MyThread1(cb, "C");

    }
}
