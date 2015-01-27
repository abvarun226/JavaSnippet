package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/18/15.
 */

interface MyFuncCons1<T> {
    MyClassCons<T> func(T n);
}

class MyClassCons<T> {
    private T val;
    MyClassCons(T v) { val = v; }
    MyClassCons() { val = null; }
    T getVal() { return val; }
}

public class ConstructorRefGeneric {
    public static void main(String[] args) {

        MyFuncCons1<Integer> myFuncCons = MyClassCons<Integer>::new;
        // or simply,
        // MyFuncCons1<Integer> myFuncCons = MyClassCons::new;

        MyClassCons<Integer> obj1 = myFuncCons.func(10);
        // or simply,
        // MyClassCons obj1 = myFuncCons.func(10);

        System.out.println("Value stored on obj1 : " + obj1.getVal());
    }
}
