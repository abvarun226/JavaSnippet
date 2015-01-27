package com.abvarun226.synchronous;

/**
 * Created by bharghav on 10/13/14.
 */
public class Synch extends Thread {

    private int threadId;
    private TargetClass target;

    public Synch(int threadId, TargetClass target) {
        this.threadId = threadId;
        this.target = target;
    }

    @Override
    public void run() {

        synchronized (target) {
            try {
                System.out.println("Secondary thread");
                sleep(2000);
                target.call(threadId);
            } catch (InterruptedException e) {
                System.err.println("Thread Interrupted");
            }
        }
    }
}
