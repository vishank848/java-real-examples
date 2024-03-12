package org.example;

public class BitWiseOperator {

    public static void main(String[] args) {
        
        boolean isM = false;
        boolean isY = false;
        boolean isA = true;

        isM |= isY | isA;

        System.out.println(isM);
        
    }
}
