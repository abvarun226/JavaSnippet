package com.abvarun226.Concurrency;

import java.util.concurrent.*;

/**
 * Created by bharghav on 1/28/15.
 */

class Sum implements Callable<Integer> {
    private int stop;

    Sum(int v) {
        stop = v;
    }

    @Override
    public Integer call() {
        int sum = 0;
        for (int i=0 ; i<stop ; i++) {
            sum += i;
        }
        return sum;
    }
}

class Hypot implements Callable<Double> {
    private double side1, side2;

    Hypot(double s1, double s2) {
        side1 = s1;
        side2 = s2;
    }

    @Override
    public Double call() {
        return Math.sqrt((side1*side1) + (side2*side2));
    }
}

class Fact implements Callable<Integer> {
    private int stop;

    Fact(int s) {
        stop = s;
    }

    @Override
    public Integer call() {
        int result = 1;
        for(int i=2 ; i<=stop ; i++) {
            result *= i;
        }
        return result;
    }
}

public class CallableFutureDemo {
    public static void main(String... args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        Future<Integer> f1;
        Future<Double> f2;
        Future<Integer> f3;

        System.out.println("Starting Demo.\n");

        f1 = es.submit(new Sum(5));
        f2 = es.submit(new Hypot(3, 4));
        f3 = es.submit(new Fact(5));

        try {
//            System.out.println("Sum   = " + f1.get());
//            System.out.println("Hypot = " + f2.get());
//            System.out.println("Fact  = " + f3.get());
            System.out.println("Sum   = " + f1.get(10, TimeUnit.MILLISECONDS));
            System.out.println("Hypot = " + f2.get(10, TimeUnit.MILLISECONDS));
            System.out.println("Fact  = " + f3.get(10, TimeUnit.MILLISECONDS));
            System.out.println("TimeUnit Example : 2 days is " + TimeUnit.DAYS.toHours(2) + " hours");
            System.out.println("TimeUnit Example : Waiting for 2 seconds...");
            TimeUnit.SECONDS.sleep(2);
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ExecutionException e) {
            System.out.println(e.getMessage());
        }

        es.shutdown();
        System.out.println("\nCompleted.\n");
    }
}
