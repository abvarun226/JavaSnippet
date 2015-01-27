package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/23/15.
 */

class NewThreadGroupDemo extends Thread {
    boolean suspendFlag;

    NewThreadGroupDemo(String threadName, ThreadGroup group) {
        super(group, threadName);
        System.out.println("New thread : " + this );
        suspendFlag = false;
        start();
    }

    @Override
    public void run() {
        try {
            for(int i=5 ; i> 0 ; i--) {
                System.out.println(getName() + " : " + i);
                Thread.sleep(1000);
                synchronized (this) {
                    while (suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(getName() + " Exiting");
    }

    synchronized public void mySuspend() {
        suspendFlag = true;
    }

    synchronized public void myResume() {
        suspendFlag = false;
        notify();
    }
}

public class ThreadGroupBDemo1 {
    public static void main(String... args) {
        ThreadGroup groupA = new ThreadGroup("Group A");
        ThreadGroup groupB = new ThreadGroup("Group B");

        NewThreadGroupDemo obj1 = new NewThreadGroupDemo("one", groupA);
        NewThreadGroupDemo obj2 = new NewThreadGroupDemo("two", groupA);
        NewThreadGroupDemo obj3 = new NewThreadGroupDemo("three", groupB);
        NewThreadGroupDemo obj4 = new NewThreadGroupDemo("four", groupB);

        System.out.println("\nHere is the output from list(): ");
        groupA.list();
        groupB.list();
        System.out.println();

        System.out.println("Suspending Group A");
        Thread tga[] = new Thread[groupA.activeCount()];
        groupA.enumerate(tga);
        for(int i=0 ; i<tga.length ; i++) {
            ((NewThreadGroupDemo) tga[i]).mySuspend();
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Resuming Group A");
        for(int i=0 ; i<tga.length ; i++) {
            ((NewThreadGroupDemo) tga[i]).myResume();
        }

        try {
            System.out.println("Wait for the child threads to complete");
            obj1.join();
            obj2.join();
            obj3.join();
            obj4.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main Thread Exiting.");
    }
}
