package com.abvarun226.Concurrency;

import java.util.concurrent.*;
import java.util.*;

/**
 * Created by bharghav on 1/28/15.
 */

class SqrtTransform extends RecursiveAction {
    final int seqThreshold = 1000;

    double[] data;

    int start, end;

    SqrtTransform(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    protected void compute() {

        if((end - start) < seqThreshold) {
            for (int i=start ; i<end ; i++) {
                data[i] = Math.sqrt(data[i]);
            }
        } else {
            int middle = (end + start)/2;
            invokeAll(new SqrtTransform(data, start, middle) , new SqrtTransform(data, middle, end));
        }
    }
}

public class ForkJoinDemo1 {
    public static void main(String... args) {
        ForkJoinPool fjp = new ForkJoinPool();

        double[] data = new double[100000];
        for (int i=0 ; i<data.length ; i++) {
            data[i] = (double) i;
        }

        System.out.println("A portion of the original sequence: ");

        for (int i=0 ; i<10 ; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("\n");

        SqrtTransform task = new SqrtTransform(data, 0, data.length);

        fjp.invoke(task);

        System.out.println("A portion of the transformed sequence: ");
        for (int i=0 ; i<10 ; i++) {
            System.out.format("%.4f ", task.data[i]);
        }
        System.out.println("\n");

    }
}
