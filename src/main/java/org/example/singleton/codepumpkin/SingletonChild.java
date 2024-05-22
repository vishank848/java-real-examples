package org.example.singleton.codepumpkin;

public class SingletonChild extends CloneableParent {
    private static SingletonChild instance = new SingletonChild();

    private SingletonChild() {
    }

    public static SingletonChild getInstance() {
        return instance;
    }

    @Override
    protected Object clone() {
        throw new RuntimeException("Clone Not Supported");
    }
}
