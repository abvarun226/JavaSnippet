package com.abvarun226.NIODemo;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by bharghav on 1/29/15.
 */
public class DirectoryList {
    public static void main(String... args) {
        String dirName = "/Users/bharghav/tools";

        try ( DirectoryStream<Path> dirPath = Files.newDirectoryStream(Paths.get(dirName)); ) {

            //for (Path contents : dirPath) {
            //    System.out.println(contents.toAbsolutePath());
            //}

            for (Path contents : dirPath) {
                BasicFileAttributes attribs = Files.readAttributes(contents, BasicFileAttributes.class);
                if(attribs.isDirectory()) {
                    System.out.print("<DIR>   ");
                } else {
                    System.out.print("        ");
                }
                System.out.println(contents.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
