package FileOperations;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by bharghav on 10/20/14.
 */

public class ReadFiles {
    public static void main(String[] args) {

        Path file = FileSystems.getDefault().getPath("/Users/bharghav/tools/bigxml.xml");
        Charset cs = Charset.defaultCharset();
        StringBuffer buf = new StringBuffer();
        try (
                BufferedReader br = Files.newBufferedReader(file, cs)
        ) {
            String line = null;
            while((line = br.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
        } catch(IOException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(buf);
    }

}
