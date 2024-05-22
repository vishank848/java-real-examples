package org.example.singleton;

public class SimpleSingleton {
    private static SimpleSingleton INSTANCE = null;

    private SimpleSingleton() {
    }

    public static SimpleSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SimpleSingleton();
        }
        return INSTANCE;
    }
}
