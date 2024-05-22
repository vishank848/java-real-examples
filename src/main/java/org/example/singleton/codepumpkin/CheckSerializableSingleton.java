package org.example.singleton.codepumpkin;

import java.io.*;

public class CheckSerializableSingleton {
    public static void main(String[] args) {

        try {
            SerializableSingleton instance1 = SerializableSingleton.getInstance();
            ObjectOutput out;

            // Serialize object state to file
            out = new ObjectOutputStream(new FileOutputStream("codePumpkin.ser"));
            out.writeObject(instance1);
            out.close();

            // deserialize from file to object
            ObjectInput in = new ObjectInputStream(new FileInputStream("codePumpkin.ser"));
            SerializableSingleton instance2 = (SerializableSingleton) in.readObject();
            in.close();

            System.out.println("instance1 hashCode = " + instance1.hashCode());
            System.out.println("instance2 hashCode = " + instance2.hashCode());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
