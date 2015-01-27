package com.abvarun226.InheritanceDemo;

/**
 * Created by bharghav on 1/9/15.
 */
public class MainClass {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird();
        Dog dog = new Dog();

        System.out.println("");

        animal.sleep();
        animal.eat();

        bird.sleep();
        bird.eat();

        dog.sleep();
        dog.eat();

        System.out.println("\nTesting1.....");
        animal = dog;
        animal.sleep();
        animal.eat();

        System.out.println("\nTesting2.....");
        animal = bird;
        animal.sleep();
        animal.eat();

//        System.out.println("\nTesting3.....");
//        bird = (Bird) animal;
//        bird.sleep();
//        bird.eat();

//        System.out.println("\nTesting4.....");
//        dog = (Dog) animal;
//        dog.sleep();
//        dog.eat();

    }
}
