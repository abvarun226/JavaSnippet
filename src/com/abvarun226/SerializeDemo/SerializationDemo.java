package com.abvarun226.SerializeDemo;

import java.io.*;

/**
 * Created by bharghav on 1/30/15.
 */

class MyClass implements Serializable {
    String name;
    int num1;
    double num2;

    MyClass(String s, int n, double d) {
        name = s;
        num1 = n;
        num2 = d;
    }

    public String toString() {
        return "Name = " + name + "  ,  num1 = " + num1 + "  ,  num2 = " + num2;
    }
}
public class SerializationDemo {
    public static void main(String... args) {
        System.out.println("Serialization : ");
        try ( ObjectOutputStream objStream1 = new ObjectOutputStream(new FileOutputStream("serialize_file1.txt"))) {
            MyClass object1 = new MyClass("Hello", 120, 1e10);
            System.out.println("Object 1 : " + object1);
            objStream1.writeObject(object1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("\nDeserialization : ");
        try ( ObjectInputStream objStream2 = new ObjectInputStream(new FileInputStream("serialize_file1.txt"))) {
            MyClass object2 = (MyClass)objStream2.readObject();
            System.out.println("Object 2 : " + object2);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
