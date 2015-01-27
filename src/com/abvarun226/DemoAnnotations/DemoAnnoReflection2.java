package com.abvarun226.DemoAnnotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Created by bharghav on 1/16/15.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
    String str();
    int val();
}

public class DemoAnnoReflection2 {
    @MyAnno2(str="Demo Annotation 2", val=500)
    public static void myMethod1(String str1, int i) {
        DemoAnnoReflection2 ob = new DemoAnnoReflection2();

        try {
            Class<?> c = ob.getClass();

            Method m = c.getMethod("myMethod1", String.class, int.class);

            MyAnno2 anno2 = m.getAnnotation(MyAnno2.class);

            System.out.println(anno2.str() + " --- " + anno2.val());

        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String... args) {
        myMethod1("Hello", 500);
    }
}
