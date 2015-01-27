package com.abvarun226.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by bharghav on 10/13/14.
 */

public class Main {
    public static void main(String[] args) {

        Path walkDir = Paths.get("/Users/bharghav/tools");

        MyFileVisitor visitor = new MyFileVisitor();

        try {
            Files.walkFileTree(walkDir,visitor);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
