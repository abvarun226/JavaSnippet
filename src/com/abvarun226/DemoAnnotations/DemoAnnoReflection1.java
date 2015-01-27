package com.abvarun226.DemoAnnotations;


import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Created by bharghav on 1/16/15.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1 {
    String str();
    int val();
}

public class DemoAnnoReflection1 {

    @MyAnno1(str="Demo Annotation 1", val=200)
    public static void myMethod1() {
        DemoAnnoReflection1 ob = new DemoAnnoReflection1();

        try {
            Class<?> c = ob.getClass();

            Method m = c.getMethod("myMethod1");

            MyAnno1 anno1 = m.getAnnotation(MyAnno1.class);

            System.out.println(anno1.str() + " -- " + anno1.val());
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String... args) {
        myMethod1();
    }
}
