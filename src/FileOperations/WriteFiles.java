package FileOperations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by bharghav on 10/20/14.
 */
public class WriteFiles {

    public static void go(short n){
        System.out.println("short");
    }
    public static void main(String[] args) {
        Path file = Paths.get("/Users/bharghav/tools/bigxml.xml");
        byte[] contents = null;
        try {
            contents = Files.readAllBytes(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String strContents = new String(contents);
        Path newFile = Paths.get("/Users/bharghav/tools/bigxml1.xml");
        Charset cs = Charset.defaultCharset();
        try (
                BufferedWriter bw = Files.newBufferedWriter(newFile, cs)
        ) {
            System.out.println(strContents);
            bw.write(strContents, 0, strContents.length());
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
