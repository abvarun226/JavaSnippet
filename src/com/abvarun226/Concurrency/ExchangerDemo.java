package com.abvarun226.Concurrency;

import java.util.concurrent.Exchanger;

/**
 * Created by bharghav on 1/28/15.
 */

class MakeString implements Runnable {
    Exchanger<String> ex;
    String str;

    MakeString(Exchanger<String> e) {
        ex = e;
        str = new String();
        new Thread(this).start();
    }

    @Override
    public void run() {
        char ch = 'A';

        for (int i=0 ; i<3 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                str += ch++;
            }
            try {
                str = ex.exchange(str);
                //System.out.println("MakeString - Got: " + str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class UseString implements Runnable {
    Exchanger<String> ex;
    String str;

    UseString(Exchanger<String> c) {
        ex = c;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i=0 ; i<3 ; i++) {
            try {
                str = ex.exchange(new String(""));
                System.out.println("UseString - Got: " + str);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
public class ExchangerDemo {
    public static void main(String... args) {
        Exchanger<String> exgr = new Exchanger<>();

        new UseString(exgr);
        new MakeString(exgr);
    }
}
