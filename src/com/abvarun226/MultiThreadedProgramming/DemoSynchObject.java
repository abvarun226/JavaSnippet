package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class CallmeSynch {
    synchronized void call(String msg) { // synchronize access to call() method using "synchronized" keyword
        System.out.print("DemoSynchObject [" + msg);
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
        System.out.println("]");
    }
}

class CallerSynch implements Runnable {

    String msg;
    Thread t;
    CallmeSynch target;

    public CallerSynch(CallmeSynch targ, String s) {
        target = targ;
        msg = s;
        t = new Thread(this);
        t.start();
    }

    public void run() {
        target.call(msg);
    }
}

public class DemoSynchObject {
    public static void main(String[] args) {
        CallmeSynch target = new CallmeSynch();
        CallmeSynch target1 = new CallmeSynch();
        CallerSynch t1 = new CallerSynch(target, "Hello");
        CallerSynch t2 = new CallerSynch(target, "Synchronised");
        CallerSynch t3 = new CallerSynch(target, "World");

        try {
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Main Interrupted");
        }
    }
}
