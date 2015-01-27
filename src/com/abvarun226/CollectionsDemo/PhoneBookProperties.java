package com.abvarun226.CollectionsDemo;

import java.io.*;
import java.util.*;

/**
 * Created by bharghav on 1/26/15.
 */
public class PhoneBookProperties {
    public static void main(String... args) {
        Properties ht = new Properties();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fin = null;
        String name, number;
        boolean changed = false;


        try {
            fin = new FileInputStream("phonebook.dat");
        } catch ( FileNotFoundException e ) {
            System.out.println(e.getMessage());
        }

        try {
            if(fin != null) {
                ht.load(fin);
                fin.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        do {
            System.out.println("Enter new name ('quit' to stop): ");
            name = "quit";
            try {
                name = br.readLine();
                if (name.equals("quit")) {
                    continue;
                }

                System.out.println("Enter the number: ");
                number = br.readLine();

                ht.put(name, number);
                changed = true;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (!name.equals("quit"));

        if (changed) {
            try {
                FileOutputStream fout = new FileOutputStream("phonebook.dat");

                ht.store(fout, "Telephone Book");
                fout.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        do {
            System.out.println("Enter the name to find ('quit' to quit): ");
            try {
                name = br.readLine();
                if (name.equals("quit")) continue;

                number = (String) ht.get(name);
                System.out.println(number);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (!name.equals("quit"));

    }
}