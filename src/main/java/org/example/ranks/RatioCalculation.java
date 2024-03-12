package org.example.ranks;

import java.util.Arrays;
import java.util.List;

public class RatioCalculation {

    public static void main(String[] args) {
        plusMinus(Arrays.asList(1, 1, 0, -1, -1));
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
    }

    private static void plusMinus(List<Integer> arr) {
        double size = arr.size();
        double countPositiveN = 0;
        double countNegativeN = 0;
        double countZeros = 0;
        for (Integer num : arr) {
            if (num > 0) {
                countPositiveN++;
            } else if (num < 0) {
                countNegativeN++;
            } else {
                countZeros++;
            }
        }
        System.out.printf("%.6f\n", countPositiveN / size);
        System.out.printf("%.6f\n", countNegativeN / size);
        System.out.printf("%.6f\n", countZeros / size);
    }
}
