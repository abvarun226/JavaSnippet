package com.abvarun226.NIODemo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by bharghav on 1/30/15.
 */
public class WriteFileMapPreJDK7 {
    public static void main(String... args) {
        RandomAccessFile fOut = null;
        FileChannel fChan = null;

        try {
            fOut = new RandomAccessFile("data/test1.txt", "rw");
            fChan = fOut.getChannel();

            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 27);

            for (int i=0 ; i<26 ; i++) {
                mBuf.put((byte)('A' + i));
            }
            mBuf.put((byte)'\n');
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fChan != null) {
                try {
                    fChan.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(fOut != null) {
                try {
                    fOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
