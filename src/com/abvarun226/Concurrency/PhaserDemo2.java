package com.abvarun226.Concurrency;

import java.util.concurrent.Phaser;

/**
 *
 * Created by bharghav on 1/28/15.
 */

class MyPhaser extends Phaser {
    int numPhases;

    MyPhaser(int parties, int phaseCount) {
        super(parties);
        numPhases = phaseCount - 1;
    }

    @Override
    protected boolean onAdvance(int phase, int numParties) {
        System.out.println("Phase " + phase + " completed\n");

        if(phase == numPhases || numParties == 0) return true;
        return false;
    }
}

class MyThread3 implements Runnable {
    Phaser phsr;
    String name;

    MyThread3(Phaser ph, String n) {
        this.phsr = ph;
        name = n;
        phsr.register();
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (!phsr.isTerminated()) {
            System.out.println("Thread " + name + " Beginning Phase " + phsr.getPhase());

            phsr.arriveAndAwaitAdvance();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

public class PhaserDemo2 {
    public static void main(String... args) {
        MyPhaser phsr = new MyPhaser(1, 4);

        System.out.println("Starting Demo\n");

        new MyThread3(phsr, "A");
        new MyThread3(phsr, "B");
        new MyThread3(phsr, "C");

        while (!phsr.isTerminated()) {
            phsr.arriveAndAwaitAdvance();
        }

        System.out.println("The Phaser has terminated.\n");

    }
}
