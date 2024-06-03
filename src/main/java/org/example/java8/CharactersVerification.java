package org.example.java8;

public class CharactersVerification {
    public static void main(String[] args) {
        Character str = 'A';
        Character str1 = null;

        if ('A' == str) {
            System.out.println("1 " + str);
        }

//        if ('A' == str1) {
//            System.out.println("2 " + str1);
//        }

        if (str == 'A') {
            System.out.println("3 " + str);
        }

        if (str1 == 'A') {
            System.out.println("4 " + str1);
        }


    }
}
