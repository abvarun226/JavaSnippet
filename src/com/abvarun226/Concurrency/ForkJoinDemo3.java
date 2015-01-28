package com.abvarun226.Concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * Created by bharghav on 1/28/15.
 */

class Sum1 extends RecursiveTask<Double> {
    final int seqThreshold = 500;
    double[] data;
    int start,end;

    Sum1(double[] vals, int s, int e) {
        data = vals;
        start = s;
        end = e;
    }

    protected Double compute() {
        double sum = 0;

        if((end - start) < seqThreshold) {
            for (int i=start ; i<end ; i++) sum += data[i];
        } else {
            int middle = (end + start)/2;
            Sum1 subTaskA = new Sum1(data, start, middle);
            Sum1 subTaskB = new Sum1(data, middle, end);

            subTaskA.fork();
            subTaskB.fork();

            sum = subTaskA.join() + subTaskB.join();
        }
        return sum;
    }
}

public class ForkJoinDemo3 {
    public static void main(String... args) {
        ForkJoinPool fjp = new ForkJoinPool();

        double[] nums = new double[5000];
        for (int i=0 ; i<nums.length ; i++) {
            nums[i] = (double) (((i%2) == 0) ? i : -i);
        }

        Sum1 task = new Sum1(nums, 0, nums.length);
        double result = fjp.invoke(task);
        System.out.println("Sum = " + result);
    }
}
