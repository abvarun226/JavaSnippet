package com.abvarun226.NIODemo;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;

/**
 * Created by bharghav on 1/29/15.
 */
public class ChannelBasedIOMapWrite {
    public static void main(String... args) {

        try ( FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test.txt"), StandardOpenOption.READ, StandardOpenOption.CREATE, StandardOpenOption.WRITE); ) {

            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 27*3);

            for (int j=0 ; j<3 ; j++) {
                for (int i = 0; i < 26; i++) {
                    mBuf.put((byte) ('A' + i));
                }
                mBuf.put((byte) '\n');
                //Thread.sleep(10000);
            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
