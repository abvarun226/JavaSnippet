package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/18/15.
 */

interface SomeFuncGenMethRef<T> {
    int SomeFunc(T[] v1, T v2);
}

class MyArrayOps {
    static <T> int countMatching(T[] vals, T v) {
        int count = 0;
        for(T val : vals) {
            if(val == v ) count++;
        }
        return count;
    }
}

public class GenericMethodRefDemo {
    static <T> int MyOp(SomeFuncGenMethRef<T> f, T[] vals, T v) {
        return f.SomeFunc(vals, v);
    }

    public static void main(String [] args) {
        Integer[] vals1 = { 1, 2, 3, 4, 5, 1, 2, 1, 4, 5};
        String[] vals2 = {"one", "two", "three", "one", "three", "four", "five"};

        System.out.println("Number of occurrences of 1 : " + MyOp(MyArrayOps::<Integer>countMatching, vals1, 1));
        System.out.println("Number of occurrences of 2 : " + MyOp(MyArrayOps::<Integer>countMatching, vals1, 2));
        System.out.println("Number of occurrences of 3 : " + MyOp(MyArrayOps::<Integer>countMatching, vals1, 3));

        System.out.println();

        System.out.println("Number of occurrences of 'one' : " + MyOp(MyArrayOps::<String>countMatching, vals2, "one"));
        System.out.println("Number of occurrences of 'two' : " + MyOp(MyArrayOps::<String>countMatching, vals2, "two"));
        System.out.println("Number of occurrences of 'three' : " + MyOp(MyArrayOps::<String>countMatching, vals2, "three"));
    }
}
