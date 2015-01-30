package com.abvarun226.NIODemo;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;


/**
 * Created by bharghav on 1/30/15.
 */
public class WriteFilePreJDK7 {
    public static void main(String... args) {
        FileOutputStream fOut = null;
        FileChannel fChan = null;

        try {
            fOut = new FileOutputStream("test.txt");
            fChan = fOut.getChannel();

            ByteBuffer mBuf = ByteBuffer.allocate(27);

            for (int i=0 ; i<26 ; i++) {
                mBuf.put((byte)('A' + i));
            }
            mBuf.put((byte)'\n');
            mBuf.rewind();
            fChan.write(mBuf);
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
