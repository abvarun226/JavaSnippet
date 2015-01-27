package com.abvarun226.MultiThreadedProgramming;

/**
 * Created by bharghav on 1/15/15.
 */
public class ReferenceToMainThread {
    public static void main(String[] args) {
        Thread t = Thread.currentThread();

        System.out.println("Current Thread: " + t);

        t.setName("My Main Thread");

        System.out.println("After setName() : " + t);

        try{
            for(int n = 5 ; n>0 ; n--) {
                System.out.println(n);
                Thread.sleep(1000);
            }
        } catch(InterruptedException e) {
            System.out.println("thread interrupt : " + e );
        }
    }
}
