package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */

class Q1 {
    int n;
    boolean valueSet = false;

    synchronized int get() {
        while(!valueSet) {
            try {
//                System.out.println("get() wait!");
                wait();
            } catch (InterruptedException e) {
                System.out.println("get() Interrupted!");
            }
        }

        System.out.println("Got : " + n);
        valueSet = false;
        notify();
        return n;
    }

    synchronized void put(int num) {
        while(valueSet) {
            try {
//                System.out.println("put() wait!");
                wait();
            } catch (InterruptedException e) {
                System.out.println("put() interrupted!");
            }
        }

        n = num;
        valueSet = true;
        System.out.println("Put : " + num);
        notify();
    }
}

class Producer1 implements  Runnable {
    Q1 q;
    Thread t;

    Producer1(Q1 q) {
        this.q = q;
        t = new Thread(this, "Producer");
        t.start();
    }

    public void run() {
        int i = 0;

        while(true) {
            q.put(i++);
            if (i > 10) {
                break;
            }
        }
        System.out.println("Exiting Producer Thread!");
    }
}

class Consumer1 implements Runnable {
    Q1 q;
    Thread t;

    Consumer1(Q1 q) {
        this.q = q;
        t = new Thread(this, "Consumer");
        t.start();
    }

    public void run() {
        while(true) {
            int temp = q.get();
            if(temp > 10) {
                break;
            }
        }
        System.out.println("Exiting Consumer Thread!");
    }
}

public class CorrectProducerConsumer {
    public static void main(String... args) {
        System.out.println("Press Control-C to stop!");
        Q1 q = new Q1();
        Producer1 p = new Producer1(q);
        Consumer1 c = new Consumer1(q);

        try {
            p.t.join();
            c.t.join();
        } catch (InterruptedException e) {
            System.out.println("main interrupted!");
        }

        System.out.println("Exiting Main Thread");
    }
}
