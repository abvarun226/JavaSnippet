package com.abvarun226.SerializeDemo;

import java.io.*;

/**
 * Created by bharghav on 1/9/15.
 */

public class DeSerializeObject {
    public static void main(String[] args) {
        Employee e = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/employee.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            e = (Employee) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }

        System.out.println("After Deserialization:");
        System.out.println(e.name);
        System.out.println(e.address);
        System.out.println(e.number);
        System.out.println(e.SSN);
    }
}
