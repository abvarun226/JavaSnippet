package com.abvarun226.NIODemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by bharghav on 1/29/15.
 */
public class ReadFilePreJDK7 {
    public static void main(String... args) {
        FileInputStream fin = null;
        FileChannel fChan = null;

        try {
            fin = new FileInputStream("/Users/bharghav/tools/bigxml.xml");
            fChan = fin.getChannel();

            ByteBuffer mBuf = ByteBuffer.allocate(128);

            int count;
            do {
                count = fChan.read(mBuf);
                if(count != -1) {
                    mBuf.rewind();
                    for (int i=0 ; i<count ; i++)
                        System.out.print((char) mBuf.get());
                }
            } while (count != -1);
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

            if(fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
