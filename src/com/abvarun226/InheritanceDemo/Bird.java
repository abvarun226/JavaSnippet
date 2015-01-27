package com.abvarun226.InheritanceDemo;

/**
 * Created by bharghav on 1/9/15.
 */
public class Bird extends Animal {
    public Bird() {
        super();
        System.out.println("A new bird has been created!");
    }

    @Override
    public void sleep() {
        System.out.println("A bird sleeps...");
    }

    @Override
    public void eat() {
        System.out.println("A bird eats...");
    }
}
