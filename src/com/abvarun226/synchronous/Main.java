package com.abvarun226.synchronous;

/**
 * Created by bharghav on 10/13/14.
 */

public class Main {
    public static void main(String[] args) {

        TargetClass target = new TargetClass();

        Synch mythread1 = new Synch(1, target);
        Synch mythread2 = new Synch(2, target);
        Synch mythread3 = new Synch(3, target);

        mythread1.start();
        mythread2.start();
        mythread3.start();
        mythread2.interrupt();

    }
}
