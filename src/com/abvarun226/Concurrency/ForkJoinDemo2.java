package com.abvarun226.Concurrency;

import com.abvarun226.JavaLangDemo.SystemDemo1;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * Created by bharghav on 1/28/15.
 */

class Transform extends RecursiveAction {
    private int seqThreshold;
    double[] data;
    int start, end;

    Transform(double[] vals, int s, int e, int seq) {
        data = vals;
        start = s;
        end = e;
        seqThreshold = seq;
    }

    protected void compute() {
        if((end-start) < seqThreshold) {
            for (int i=start ; i<end ; i++) {
                if( (i % 2) == 0) {
                    data[i] = Math.sqrt(data[i]);
                } else {
                    data[i] = Math.cbrt(data[i]);
                }
            }
        } else {
            int middle = (end + start) / 2;
            invokeAll(new Transform(data, start, middle, seqThreshold) , new Transform(data, middle, end, seqThreshold));
        }
    }
}
public class ForkJoinDemo2 {
    public static void main(String... args) {
        int pLevel = 4;
        int threshold = 1000;

        long beginT, endT;

        ForkJoinPool fjp = new ForkJoinPool(pLevel);
        double[] nums = new double[100000];
        for (int i=0 ; i<nums.length ; i++) {
            nums[i] = (double) i;
        }

        System.out.println("A portion of array before transform: ");
        for (int i=0 ; i<10 ; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n");

        Transform task = new Transform(nums, 0 , nums.length, threshold);

        beginT = System.nanoTime();
        fjp.invoke(task);
        endT = System.nanoTime();

        for (int i=0 ; i<10 ; i++) {
            System.out.format("%.4f", nums[i]);
        }

        Runtime myRun = Runtime.getRuntime();
        System.out.println("\n");
        System.out.println("Level of Parallelism : " + fjp.getParallelism() + " / " + myRun.availableProcessors());
        System.out.println("Sequential Threshold : " + threshold);
        System.out.println("Elapsed Time         : " + (endT - beginT) + " ns");
        System.out.println();
    }
}
