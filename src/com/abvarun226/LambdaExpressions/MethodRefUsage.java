package com.abvarun226.LambdaExpressions;

import java.util.*;

/**
 * Created by bharghav on 1/18/15.
 */

class MyClass {
    private int val;

    MyClass(int v) { val = v; }
    int getVal() { return val; }
}

public class MethodRefUsage {
    static int compareMC(MyClass a, MyClass b) {
        return a.getVal() - b.getVal();
    }

    public static void main(String [] args) {
        ArrayList<MyClass> vals = new ArrayList<>();
        vals.add(new MyClass(10));
        vals.add(new MyClass(1));
        vals.add(new MyClass(9));
        vals.add(new MyClass(20));
        vals.add(new MyClass(15));
        vals.add(new MyClass(13));
        vals.add(new MyClass(16));
        vals.add(new MyClass(20));

        MyClass maxObj = Collections.max(vals, MethodRefUsage::compareMC);

        System.out.println("Maximum value is : " + maxObj.getVal());

    }
}
