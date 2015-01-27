package com.abvarun226.DemoAnnotations;

import java.lang.annotation.*;
import java.lang.reflect.*;

/**
 * Created by bharghav on 1/16/15.
 */

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno3 {
    String str();
    int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
    String description();
}

@What(description = "An annotation test class")
@MyAnno3(str = "DemoReflection3", val = 100)
public class DemoAnnoReflection3 {

    @What(description = "An annotation test method")
    @MyAnno3(str = "DemoMethod1" , val = 200)
    public static void DemoMethod1() {
        DemoAnnoReflection3 ob = new DemoAnnoReflection3();

        try {
            Annotation annos[] = ob.getClass().getAnnotations();

            System.out.println("All annotations for DemoReflection3 class : ");
            for(Annotation a : annos) {
                System.out.println(a);
            }

            System.out.println();

            Method m = ob.getClass().getMethod("DemoMethod1");
            annos = m.getAnnotations();

            System.out.println("All annotations for DemoMethod1 method : ");
            for(Annotation a : annos) {
                System.out.println(a);
            }
            System.out.println();
        } catch (NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        DemoMethod1();
    }
}
