package com.abvarun226.ByteBufferExample;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * Created by bharghav on 1/9/15.
 */
public class ByteBufferDemo {

    public static void main(String[] args) {

        Path path = Paths.get("/Users/bharghav/portal2_hd.wmv");
        FileChannel fileChannel = null;

        long startTime = new Date().getTime();

        try {
            fileChannel = FileChannel.open(path);

            ByteBuffer buffer = ByteBuffer.allocateDirect(1024 * 10);
//            ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);

            System.out.println("Is a direct buffer: " + buffer.isDirect());
            System.out.println("Buffer has a backing array: " + buffer.hasArray());
            System.out.println("Reading file...");

            int noOfBytesRead = fileChannel.read(buffer);

            for (int i = 0; i < 25; i++) {
                while (noOfBytesRead != -1) {
                    buffer.clear();
                    noOfBytesRead = fileChannel.read(buffer);
                }
                buffer.clear();
                fileChannel.position(0);
                noOfBytesRead = fileChannel.read(buffer);
            }

            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long endTime = new Date().getTime();
        System.out.println("\nTime taken (millis): " + (endTime - startTime));
    }
}
