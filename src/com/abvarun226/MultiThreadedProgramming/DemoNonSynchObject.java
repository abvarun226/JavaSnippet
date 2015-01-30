package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class CallMe1 {
    void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class Caller implements Runnable {

    String msg;
    Thread t;
    CallMe1 target;

    public Caller(CallMe1 targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        target.call(msg);
    }
}

public class DemoNonSynchObject {
    public static void main(String[] args) {
        CallMe1 target = new CallMe1();
        Caller t1 = new Caller(target, "Hello");
        Caller t2 = new Caller(target, "Not Synchronised");
        Caller t3 = new Caller(target, "World");


        try {
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main Interrupted");
        }
    }
}
