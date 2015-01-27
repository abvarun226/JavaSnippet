package com.abvarun226.LambdaExpressions;

/**
 * Created by bharghav on 1/18/15.
 *
 * A factory for objects of any type of MyFuncFactory objects
 * It can be used to create any type of object that has a constructor compatible with its first parameter
 *
 */

interface MyFuncFactory<R, T> {
    R func(T n);
}

interface MyArrayCreator<T> {
    T func(int n);
}

class MyClassFactory<T> {
    private T val;

    MyClassFactory(T v) { val = v; }
    MyClassFactory() { val = null; }
    T getVal() { return val; }
}

class MyClassFactory2 {
    String str;

    MyClassFactory2(String v) { str = v; }
    MyClassFactory2() { str = ""; };
    String getVal() { return str; }
}

class MyClass1 {
    private int val;

    MyClass1(int v) { val = v; }
    MyClass1() { val = 0; }
    int getVal() { return val; }
}

public class ConstructorRefGenericPracticalUse {
    // myClassFactory can create any type of object whose class has a constructor that is compatible with func() in MyFuncFactory interface
    static <R, T> R myClassFactory(MyFuncFactory<R,T> f,  T v) {
        return f.func(v);
    }

    public static void main(String[] args) {
        MyFuncFactory<MyClassFactory<Double>, Double> myClassCons = MyClassFactory<Double>::new;
        MyClassFactory<Double> mc = myClassFactory(myClassCons, 10.1);
        System.out.println("Val stored in mc : " + mc.getVal());

        MyFuncFactory<MyClassFactory2, String> myClassCons2 = MyClassFactory2::new;
        MyClassFactory2 mc2 = myClassFactory(myClassCons2, "Hello");
        System.out.println("String stored in mc2 : " + mc2.getVal());

        MyClassFactory2 mc3 = myClassCons2.func("World");
        System.out.println("String stored in mc3 : " + mc3.getVal());

        MyArrayCreator<MyClass1[]> myClassCons3 = MyClass1[]::new;
        MyClass1[] a = myClassCons3.func(2);
        a[0] = new MyClass1(1);
        a[1] = new MyClass1(2);

        MyClassFactory[] ab = {new MyClassFactory("Hello"), new MyClassFactory("World"), new MyClassFactory(1)};
        int count = 0;
        for(MyClassFactory temp : ab) {
            System.out.println("Index [" + count + "] " + temp.getVal());
            count++;
        }

        // What is wrong here?
        // MyFuncFactory<MyClassFactory<String>[], String> myClassCons4 = MyClassFactory<String>[]::new;



    }
}
