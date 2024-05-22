package org.example.singleton.codepumpkin;

public class SerializableSingleton {

    //Eager Initialization
//    private static SerializableSingleton instance = new SerializableSingleton();
//
//    private SerializableSingleton() {
//        System.out.println("Constructor is being called");
//    }
//
//    public static SerializableSingleton getInstance() {
//        return instance;
//    }

    private static final long serialVersionUID = 1L;
    private static SerializableSingleton instance = new SerializableSingleton();

    // make additional fields transient
    transient String[] xyz = {"xyz1", "xyz2", "xyz3"};

    private SerializableSingleton() {
    }

    public static SerializableSingleton getInstance() {
        return instance;
    }

    protected Object readResolve() {
        return getInstance();
    }
}
