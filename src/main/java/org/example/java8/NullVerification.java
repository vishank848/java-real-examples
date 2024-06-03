package org.example.java8;

public class NullVerification {
    public static void main(String[] args) {
        String str = "str";
        String str1 = null;

        if ("str".equals(str)) {
            System.out.println("1 " + str);
        }

        if ("str".equals(str1)) {
            System.out.println("2 " + str1);
        }

        if (str.equals("str")) {
            System.out.println("3 " + str);
        }

        if (str1.equals("str")) {
            System.out.println("4 " + str1);
        }


    }
}
