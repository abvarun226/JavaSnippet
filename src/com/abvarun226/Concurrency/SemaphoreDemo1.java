package com.abvarun226.Concurrency;

import java.util.*;
import java.util.concurrent.Semaphore;

/**
 * Created by bharghav on 1/27/15.
 */

class Shared {
    static int count = 0;
}

class IncThread implements Runnable {
    String name;
    Semaphore sem;

    IncThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " is waiting for a permit.");
            sem.acquire();
            System.out.println(name + " gets a permit.");

            for (int i=0 ; i<5 ; i++) {
                Shared.count++;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(name + " releases the permit.");
        sem.release();
    }
}

class DecThread implements Runnable {
    String name;
    Semaphore sem;

    DecThread(Semaphore s, String n) {
        sem = s;
        name = n;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " is waiting for a permit.");

            sem.acquire();
            System.out.println(name + " gets a permit.");

            for (int i=0 ; i<5 ; i++) {
                Shared.count--;
                System.out.println(name + " : " + Shared.count);

                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        System.out.println(name + " releases the permit.");
        sem.release();
    }
}
public class SemaphoreDemo1 {
    public static void main(String... args) {
        Semaphore sem = new Semaphore(1);

        new IncThread(sem, "A");
        new DecThread(sem, "b");

    }
}
