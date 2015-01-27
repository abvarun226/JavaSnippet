package com.abvarun226.JavaLangDemo;

import java.io.IOException;

/**
 * Created by bharghav on 1/20/15.
 */
public class RuntimeExecDemo1 {
    public static void main(String... args) {
        Runtime r = Runtime.getRuntime();
        Process p = null;

        try {
            p = r.exec("/Applications/KeePassX.app/Contents/MacOS/KeePassX");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Still Alive? " + p.isAlive());
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            System.out.println("Exception : Still Alive? " + p.isAlive());
        }
        System.out.println("Finally, Still Alive? " + p.isAlive());
        System.out.println("Exit value = " + p.exitValue());
    }
}
