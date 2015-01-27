package com.abvarun226.SerializeDemo;

import java.io.*;

/**
 * Created by bharghav on 1/9/15.
 */

class Employee implements Serializable {
    public String name;
    public String address;
    public transient int SSN;
    public int number;
    public void mailCheck() {
        System.out.println("Mailing a check to " + name + " " + address);
    }
}
public class SerializeObject {
    public static void main(String[] args) {
        Employee e = new Employee();
        e.name = "Varun";
        e.address = "Vidyaranyapura";
        e.number = 226;
        e.SSN = 1234;
        try {
            FileOutputStream fileOut = new FileOutputStream("/tmp/employee.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(e);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in /tmp/employee.ser");
        } catch(NotSerializableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("IOException : " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
