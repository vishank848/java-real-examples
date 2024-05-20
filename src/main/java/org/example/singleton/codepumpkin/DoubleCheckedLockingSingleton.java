package org.example.singleton.codepumpkin;

public class DoubleCheckedLockingSingleton {
    private static DoubleCheckedLockingSingleton instance;

    private DoubleCheckedLockingSingleton() {
    }

    public static DoubleCheckedLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                instance = new DoubleCheckedLockingSingleton();
            }
        }
        return instance;
    }

    public static DoubleCheckedLockingSingleton getInstance2() {
        if (instance == null) {
            synchronized (DoubleCheckedLockingSingleton.class) {
                if (instance == null) {
                    instance = new DoubleCheckedLockingSingleton();
                    System.out.println("Instance Created");
                }
            }
        }
        return instance;
    }
}
