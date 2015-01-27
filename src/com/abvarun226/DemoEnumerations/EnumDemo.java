package com.abvarun226.DemoEnumerations;

/**
 * Created by bharghav on 1/16/15.
 */

enum Apple {
    Jonathan(10), GoldenDel(9), RedDel(12), Winesap(15), Cortland(8);

    private int price;

    // Constructor
    Apple(int p) {
        price = p;
    }

    int getPrice() {
        return price;
    }
}

public class EnumDemo {
    public static void main(String... args) {
        Apple ap;

        System.out.println("Winesap costs " + Apple.Winesap.getPrice() + " cents\n");

        // Display all apples and prices
        System.out.println("All apples and prices");
        System.out.println("----------------------");
        for(Apple a : Apple.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents");
        }
    }
}
