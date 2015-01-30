package com.abvarun226.NIODemo;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by bharghav on 1/30/15.
 */
public class ReadFileMapPreJDK7 {
    public static void main(String... args) {
        FileInputStream fin = null;
        FileChannel fChan = null;

        try {
            fin = new FileInputStream("/Users/bharghav/tools/bigxml.xml");
            fChan = fin.getChannel();
            long fsize = fChan.size();
            MappedByteBuffer mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fsize);

            for (int i=0 ; i<fsize ; i++) {
                System.out.print((char) (mBuf.get()));
            }
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
