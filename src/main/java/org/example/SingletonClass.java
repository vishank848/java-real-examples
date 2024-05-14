package org.example;

import java.io.Serializable;

public class SingletonClass implements Cloneable, Serializable {
    private static final SingletonClass INSTANCE = new SingletonClass();
    private static final long serialVersionUID = -6104194104173023642L;

    private SingletonClass() {

    }

    public synchronized SingletonClass getInstance() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE;
    }
}
