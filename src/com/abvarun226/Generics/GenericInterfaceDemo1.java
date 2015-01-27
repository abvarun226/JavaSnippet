package com.abvarun226.Generics;

/**
 * Created by bharghav on 1/16/15.
 */

interface minmax<T extends Comparable<T>> {
    T min();
    T max();
}

class MyClass<T extends Comparable<T>> implements minmax<T>{
    T vals[];

    MyClass(T[] o) {
        vals = o;
    }

    public T min() {
        T minv = vals[0];

        for(T a : vals) {
            if(a.compareTo(minv) < 0) {
                minv = a;
            }
        }
        return minv;
    }

    public T max() {
        T maxv = vals[0];

        for(T a : vals) {
            if(a.compareTo(maxv) > 0) {
                maxv = a;
            }
        }
        return maxv;
    }
}

public class GenericInterfaceDemo1 {
    public static void main(String[] args) {
        Integer[] inums = {3, 8, 9, 10, 1, 2};
        Character[] chars = {'b', 'a', 'z', 'd', 'v', 'm', 'z'};
        MyClass<Integer> iob = new MyClass<>(inums);
        MyClass<Character> cob = new MyClass<>(chars);

        System.out.println("Min value in inums = " + iob.min());
        System.out.println("Max value in inums = " + iob.max());
        System.out.println();
        System.out.println("Min value in chars = " + cob.min());
        System.out.println("Max value in chars = " + cob.max());
        System.out.println();
    }
}
