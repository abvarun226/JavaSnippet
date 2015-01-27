package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/22/15.
 */

class ThreadTest implements Runnable {
    Thread t;
    Thread parent;

    public ThreadTest(String name, Thread p) {
        parent = p;
        t = new Thread(this, name);
        System.out.println("New Thread Spawned : " + t);
        t.start();
    }

    public void run() {
        boolean flag= true;
        int i = 0;
        while(flag) {
            i++;
            System.out.println("Thread Started... Counter ==> " + i);
            System.out.println("State of Parent Thread ==> " + parent.getState());
            System.out.println("Is Parent Thread Alive?  ==> " + parent.isAlive());
            System.out.println();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ( i > 10 ) {
                break;
            }
        }
    }
}
public class ThreadInBackGroundDemo {
    public static void main(String... args) {
        Thread t = Thread.currentThread();
        System.out.println("Is Parent Thread Alive? " + t.isAlive());
        ThreadTest obj = new ThreadTest("MyTest", t);
        System.out.println("Main Program exited!");
    }
}
