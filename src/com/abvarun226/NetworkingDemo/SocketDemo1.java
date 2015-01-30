package com.abvarun226.NetworkingDemo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by bharghav on 1/30/15.
 */
public class SocketDemo1 {
    public static void main(String... args) throws  Exception {
        Socket s = new Socket("whois.internic.net", 43);

        InputStream in = s.getInputStream();
        OutputStream out = s.getOutputStream();

        String myStr = "yahoo.com\n";

        System.out.print("Enter hostname: ");
        Scanner scan = new Scanner(System.in);
        myStr = scan.nextLine();
        myStr += "\n";
        byte[] buf = myStr.getBytes();
        out.write(buf);

        int c;
        while((c = in.read()) != -1) {
            System.out.print((char) c);
        }

        s.close();
    }
}
