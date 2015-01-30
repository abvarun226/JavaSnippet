package com.abvarun226.NIODemo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;

/**
 * Created by bharghav on 1/29/15.
 */
public class ChannelBasedIORead {
    public static void main(String... args) {
        Path filePath = null;

        String readContent = "";
        ByteBuffer mBuf = ByteBuffer.allocate(128);

//        try {
//            filePath = Paths.get("/Users/bharghav/tools/bigxml.xml");
//        } catch (InvalidPathException e) {
//            e.printStackTrace();
//        }

        try ( // SeekableByteChannel fChan = Files.newByteChannel(filePath);
              SeekableByteChannel fChan = Files.newByteChannel(Paths.get("/Users/bharghav/tools/bigxml.xml"));
        ) {

            int count = fChan.read(mBuf);

            while(count != -1) {

                mBuf.rewind();

                for (int i=0 ; i<count ; i++) {
                    //System.out.print((char)mBuf.get());
                    readContent += (char)mBuf.get();
                }

                count = fChan.read(mBuf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(readContent);
    }
}
