package com.abvarun226.Concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bharghav on 1/28/15.
 */

class Shared1 {
    static AtomicInteger ai = new AtomicInteger(0);
}

class AtomThread implements Runnable {
    String name;

    AtomThread(String n) {
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        for (int i=1 ; i<=3 ; i++) {
            System.out.println(name + " got : " + Shared1.ai.getAndSet(i));
        }
    }
}
public class AtomicOpsDemo {
    public static void main(String... args) {
        new AtomThread("A");
        new AtomThread("B");
        new AtomThread("C");
    }
}
