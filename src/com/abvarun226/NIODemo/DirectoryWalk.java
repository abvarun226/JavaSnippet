package com.abvarun226.NIODemo;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by bharghav on 1/29/15.
 */

class MyFileVisitor extends SimpleFileVisitor<Path> {
    public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}

public class DirectoryWalk {
    public static void main(String... args) {
        String dirName = "/Users/bharghav/tools";

        System.out.println("Directory tree starting with " + dirName + " : \n");

        try {
            Files.walkFileTree(Paths.get(dirName), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
