package com.abvarun226.JavaLangDemo;

import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.Properties;

/**
 * Created by bharghav on 1/21/15.
 */
public class SystemDemo1 {
    public static void main(String... args) {

        System.out.println("Current Time (ms) : " + System.currentTimeMillis());

        System.out.println();

        Map<String,String> envVar = System.getenv();
        for (Map.Entry<String,String> t : envVar.entrySet()) {
            System.out.println(t.getKey() + " -- " + t.getValue());
        }

        System.out.println();

        Properties p = System.getProperties();
        for (Map.Entry<Object,Object> t1 : p.entrySet()) {
            System.out.println(t1.getKey() + " -- " + t1.getValue());
        }

        System.out.println();

        SecurityManager sm = System.getSecurityManager();
        System.out.println("Security Manager: " + sm);

        System.out.println();

        System.out.println("NanoTime : " + System.nanoTime());

        System.out.println();

        byte[] a = {65,66,67,68,69,70,71,72,73,74};
        byte[] b = {77,77,77,77,77,77,77,77,77,77};

        System.out.println("a = " + new String(a));
        System.out.println("b = " + new String(b));
        System.arraycopy(a, 0, b, 0, a.length);
        System.out.println("a = " + new String(a));
        System.out.println("b = " + new String(b));
        System.arraycopy(a, 0, a, 1, a.length - 1);
        System.arraycopy(b, 1, b, 0, b.length - 1);
        System.out.println("a = " + new String(a));
        System.out.println("b = " + new String(b));

        Class t3 = envVar.getClass();
        System.out.println(t3.getCanonicalName() + " -- " + t3.getName() + " -- " + t3.getTypeName() + " -- " + t3.getFields().length);


    }
}
