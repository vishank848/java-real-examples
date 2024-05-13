package org.example.java8.functional;

@FunctionalInterface
public interface FunctionalA /*extends FunctionalB*/ {
    String add(int a, int b);

    default void getNumber(int c) {
        System.out.println(c);
    }
}
