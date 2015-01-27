package com.abvarun226.filefinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by bharghav on 10/13/14.
 */

public class Main {
    public static void main(String[] args) throws IOException{

        Path start = Paths.get("/Users/bharghav/tools");
        String pattern = "dashboardv2*";

        FileFinder finder = new FileFinder(pattern);
        Files.walkFileTree(start, finder);

        ArrayList<Path> foundFiles = finder.foundPaths;

        System.out.println(foundFiles);
    }
}
