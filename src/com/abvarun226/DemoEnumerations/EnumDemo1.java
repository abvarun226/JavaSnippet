package com.abvarun226.DemoEnumerations;


/**
 * Created by bharghav on 1/16/15.
 */

enum Apple1 {
    Jonathan(10), GoldenDel(9), RedDel, Winesap(15), Cortland(8);

    private int price;

    Apple1(int p) {
        price = p;
    }

    Apple1() {
        price = -1;
    }

    int getPrice() {
        return price;
    }
}

public class EnumDemo1 {
    public static void main(String... args) {
        Apple1 ap;

        for(Apple1 a : Apple1.values()) {
            System.out.println(a + " costs " + a.getPrice() + " cents.");
        }

    }
}
