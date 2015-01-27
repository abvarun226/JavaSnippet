package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class NewThreadControl implements Runnable {
    String name;
    Thread t;
    boolean suspendFlag;

    public NewThreadControl(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("New Thread : " + t);
        suspendFlag = false;
        t.start();
    }

    public void run() {
        try {
            for(int i=15 ; i>0 ; i--) {
                System.out.println("Thread " + name + " : " + i);
                Thread.sleep(200);
                synchronized (this) {
                    while(suspendFlag) {
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(name + " exiting!");
    }

    synchronized void mySuspend() {
        suspendFlag = true;
    }

    synchronized void myResume() {
        suspendFlag = false;
        notify();
    }
}

public class DemoControlThreads {
    public static void main(String... args) {
        NewThreadControl ob1 = new NewThreadControl("One");
        NewThreadControl ob2 = new NewThreadControl("Two");

        try {
            Thread.sleep(1000);
            ob1.mySuspend();
            System.out.println("Suspending Thread " + ob1.t.getName());
            Thread.sleep(1000);
            ob1.myResume();
            System.out.println("Resuming Thread " + ob1.t.getName());
            ob2.mySuspend();
            System.out.println("Suspending Thread " + ob2.t.getName());
            Thread.sleep(1000);
            ob2.myResume();
            System.out.println("Resuming Thread " + ob2.t.getName());
        } catch (InterruptedException e) {
            System.out.println("Main Thread Interrupted!");
        }

        System.out.println("State of " + ob1.t.getName() + " : " + ob1.t.getState());
        System.out.println("State of " + ob2.t.getName() + " : " + ob2.t.getState());
        try {
            System.out.println("Waiting for the child threads to complete");
            ob1.t.join();
            ob2.t.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("State of " + ob1.t.getName() + " : " + ob1.t.getState());
        System.out.println("State of " + ob2.t.getName() + " : " + ob2.t.getState());

        System.out.println("Main Thread Exiting!");
    }
}
