package com.abvarun226.NIODemo;

import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;

/**
 * Created by bharghav on 1/29/15.
 */
public class ChannelBasedIOMapRead {
    public static void main(String... args) {

        try ( FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("/Users/bharghav/tools/bigxml.xml")); ) {

            long size = fChan.size();

            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, size);

            for (int i=0 ; i<size ; i++) {
                System.out.print((char) mBuf.get());
            }

        } catch (InvalidPathException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
