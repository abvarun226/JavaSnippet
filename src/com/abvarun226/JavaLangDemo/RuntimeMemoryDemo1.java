package com.abvarun226.JavaLangDemo;

/**
 * Created by bharghav on 1/22/15.
 */
public class RuntimeMemoryDemo1 {
    public static void main(String... args) {
        final int mb = 1024 * 1024;

        Runtime obj = Runtime.getRuntime();

        System.out.println();
        System.out.println("JVM Memory Usage Stats");
        System.out.println("======================");

        System.out.println("Max Memory   : " + obj.maxMemory()/mb + " mb");

        System.out.println("Total Memory : " + obj.totalMemory()/mb + " mb");

        System.out.println("Free Memory  : " + obj.freeMemory()/mb + " mb");

        System.out.println("Used Memory  : " + (obj.totalMemory() - obj.freeMemory())/mb + " mb");

        System.out.println();

        System.out.println("Available Processors : " + obj.availableProcessors());

    }
}
