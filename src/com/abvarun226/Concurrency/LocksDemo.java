package com.abvarun226.Concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by bharghav on 1/28/15.
 */

class SharedResource {
    static int count = 0;
}

class MyThread5 implements Runnable {
    String name;
    ReentrantLock lock;

    MyThread5(ReentrantLock l , String n) {
        name = n;
        lock = l;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Starting " + name);
        try {
            System.out.println(name + " is waiting to lock count.");
            lock.lock();
            System.out.println(name + " has acquired lock.");

            SharedResource.count++;
            System.out.println(name + " : " + SharedResource.count);
            System.out.println(name + " is sleeping.\n");

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(name + " is unlocking count.\n");
            lock.unlock();
        }
    }
}

public class LocksDemo {
    public static void main(String... args) {
        ReentrantLock lock = new ReentrantLock();

        new MyThread5(lock, "A");
        new MyThread5(lock, "B");
    }
}
