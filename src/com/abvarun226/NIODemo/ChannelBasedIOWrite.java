package com.abvarun226.NIODemo;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;

/**
 * Created by bharghav on 1/29/15.
 */
public class ChannelBasedIOWrite {
    public static void main(String... args) {

        try( SeekableByteChannel fChan = Files.newByteChannel(Paths.get("data/test.txt"), StandardOpenOption.CREATE, StandardOpenOption.WRITE); ) {

            ByteBuffer mBuf = ByteBuffer.allocate(27*100);

            for(int j=0 ; j<3 ; j++) {
                for (int i = 0; i < 26; i++) {
                    mBuf.put((byte) ('A' + i));
                }

                mBuf.put((byte) ('\n'));
                mBuf.rewind();
                fChan.write(mBuf);
                mBuf.rewind();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
