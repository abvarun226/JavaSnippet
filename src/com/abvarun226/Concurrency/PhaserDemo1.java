package com.abvarun226.Concurrency;

import java.util.concurrent.Phaser;

/**
 * Created by bharghav on 1/28/15.
 */

class MyThread2 implements Runnable {
    Phaser phsr;
    String name;

    MyThread2(Phaser ph, String n) {
        name = n;
        phsr = ph;
        phsr.register();
        new Thread(this, name).start();
    }

    @Override
    public void run() {
        System.out.println("Thread " + name + " Beginning Phase One");
        phsr.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Two");
        phsr.arriveAndAwaitAdvance();

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println("Thread " + name + " Beginning Phase Three");
        phsr.arriveAndDeregister();
    }
}
public class PhaserDemo1 {
    public static void main(String... args) {
        Phaser phsr = new Phaser(1);
        int currentPhase;

        System.out.println("Starting Demo...");

        new MyThread2(phsr, "A");
        new MyThread2(phsr, "B");
        new MyThread2(phsr, "C");

        currentPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete.");

        currentPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete.");

        currentPhase = phsr.getPhase();
        phsr.arriveAndAwaitAdvance();
        System.out.println("Phase " + currentPhase + " Complete.");

        phsr.arriveAndDeregister();

        if(phsr.isTerminated()) {
            System.out.println("The Phaser has terminated.");
        }
    }
}
