package org.example.ranks;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleArraySum {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5, 9);
        List<Integer> arr1 = Arrays.asList(1000000001, 1000000002, 1000000003, 1000000004, 1000000005);
        System.out.println(arr.stream().reduce(0, Integer::sum));
        System.out.println(addNumbersOnlyNotZero(arr1));
    }
    
    private static int addNumbersOnlyNotZero(List<Integer> binaryNumbers) {
        BigInteger bigInteger = BigInteger.valueOf(binaryNumbers.getFirst());
        BigInteger sum = null;
        for (int i = 1; i < binaryNumbers.size(); i++) {
            System.out.println(BigInteger.valueOf(binaryNumbers.get(i)));
            sum = bigInteger.add(BigInteger.valueOf(binaryNumbers.get(i)));
        }
        return sum.intValue();
    }

    private static int addBigNumbers(Integer a, Integer b) {
        return new BigInteger(String.valueOf(a)).add(BigInteger.valueOf(b)).intValue();
    }

}
