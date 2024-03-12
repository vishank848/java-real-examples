package org.example;

import java.util.StringJoiner;

public class StringJoinerExample {
    public static void main(String[] args) {
        StringJoiner joinNames = new StringJoiner(","); // passing comma(,) as delimiter   

        // Adding values to StringJoiner  
        joinNames.add("Rahul");
        joinNames.add("Raju");
        joinNames.add("Peter");

        System.out.println(joinNames);
        
    }
}
