package com.abvarun226.JavaLangDemo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by bharghav on 1/20/15.
 */
public class ProcessBuilderDemo1 {
    public static void main(String... args) {
        ProcessBuilder pb = new ProcessBuilder("/usr/bin/open", "/Users/bharghav/test1.txt");
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File f = pb.directory();
        System.out.println("Current working directory : " + f);

        Map<String, String> env = pb.environment();
        for (Map.Entry<String,String> temp : env.entrySet()) {
            System.out.println(temp.getKey() + " -- " + temp.getValue());
        }
    }
}
