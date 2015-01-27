package com.abvarun226.JavaLangDemo;

/**
 * Created by bharghav on 1/22/15.
 *
 * Encounters "java.lang.OutOfMemoryError: Java heap space" after 12th iteration in my Mac
 *
 */

public class JavaOutOfMemoryDemo {
    void consumeMemory() throws InterruptedException {
        int count = 20;
        System.out.println("Starting the OutOfMemory Test");
        for(int i=1 ; i < 20 ; i++) {
            System.out.println("Iteration " + i + "] FreeMemory : " + Runtime.getRuntime().freeMemory() );
            int loop = 2;
            int[] fillMemoryVar = new int[count];
            do {
                fillMemoryVar[loop] = 0;
                loop--;
            } while(loop > 0);
            count *= 5;
            System.out.println("\nRequired Memory for next loop: " + count);
            Thread.sleep(1000);
        }
    }
    public static void main(String... args) throws InterruptedException {
        JavaOutOfMemoryDemo obj = new JavaOutOfMemoryDemo();
        obj.consumeMemory();
    }
}
