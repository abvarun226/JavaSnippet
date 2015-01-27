package com.abvarun226.filestreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by bharghav on 10/13/14.
 */
public class Main {
    public static void main(String[] args) {

        try(Scanner s = new Scanner(new BufferedReader(new FileReader("/Users/bharghav/tokenized_file.txt")))) {

            s.useDelimiter(",");
            while(s.hasNext()) {
                System.out.println(s.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
