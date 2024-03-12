package org.example.ranks;

import java.util.Arrays;
import java.util.List;

public class BigSum {
    public static void main(String[] args) {
        System.out.println(
                aVeryBigSum(Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L)));
    }

    public static long aVeryBigSum(List<Long> ar) {
        // Write your code here
        long sum = 0;
        for (Long num : ar) {
            sum += num;
        }
        return sum;
    }
}
