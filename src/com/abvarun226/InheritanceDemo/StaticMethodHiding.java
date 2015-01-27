package com.abvarun226.InheritanceDemo;

/**
 * Created by bharghav on 1/21/15.
 */
class Animal1 {
    public static void testClassMethod() {
        System.out.println("The static method in Animal");
    }

    public void testInstanceMethod(){
        System.out.println("The instance method in Animal");
    }
}

class Cat1 extends Animal1 {
    public static void testClassMethod() {
        System.out.println("The static method in Cat");
    }

    public void testInstanceMethod() {
        System.out.println("The instance method in Cat");
    }
}

public class StaticMethodHiding {
    public static void main(String... args) {
        Cat1 myCat = new Cat1();
        Animal1 myAnimal = myCat;
        Animal1.testClassMethod();
        Cat1.testClassMethod();
        myCat.testInstanceMethod();
    }
}
