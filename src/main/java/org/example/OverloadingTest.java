package org.example;

public class OverloadingTest {

    public static void main(String[] args) {
        new OverloadingTest().some(null);
    }

    void some(Integer n) {
        System.out.println("d" + n);
    }

    void some(Object n) {
        System.out.println(n);
    }

//    void some(String n) {
//        System.out.println(n);
//    }
}
