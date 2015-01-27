package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class CallMe2 {
    void call(String msg) {
        System.out.print("DemoSynchObject2 [" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller1 implements Runnable {
    String msg;
    CallMe2 target;
    Thread t;

    public Caller1(CallMe2 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        synchronized (target) { // synchronize access to call method using "synchronized" block
            target.call(msg);
        }
    }
}

public class DemoSynchObject2 {
    public static void main(String... args) {
        CallMe2 target = new CallMe2();
        Caller1 t1 = new Caller1(target, "Hello");
        Caller1 t2 = new Caller1(target, "Synchronized");
        Caller1 t3 = new Caller1(target, "World");

        try {
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main Interrupted");
        }
    }
}
