package org.example.singleton.codepumpkin;

public class CloneableParent implements Cloneable {

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Swallowing Exception.");
        }
        return null;
    }
}
