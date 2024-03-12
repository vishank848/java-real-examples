package org.example.ranks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MinMaxSum {
    public static void main(String[] args) {
        miniMaxSum(Arrays.asList(1, 3, 5, 7, 9));
        miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
        miniMaxSum(Arrays.asList(7, 69, 2, 221, 8974));
        miniMaxSum(Arrays.asList(396285104, 573261094, 759641832, 819230764, 364801279));
    }

    public static void miniMaxSum(List<Integer> arr) {
        int numberOfElements = arr.size() - 1;
        List<Long> list = generateCombinations(arr, numberOfElements, 0,
                new int[numberOfElements], 0, new ArrayList<>());
        long max = list.stream().mapToLong(v -> v)
                .max().orElseThrow(NoSuchElementException::new);
        long min = list.stream().mapToLong(v -> v)
                .min().orElseThrow(NoSuchElementException::new);
        System.out.println(STR."\{min} \{max}");
    }

    static List<Long> generateCombinations(List<Integer> arr, int numberOfElements, int index,
                                              int[] data, int i, List<Long> sums) {
        long sum = 0;
        if (index == numberOfElements) {
            for (int j = 0; j < numberOfElements; j++) {
                sum += data[j];
            }
            sums.add(sum);
            return sums;
        }
        if (i >= arr.size())
            return sums;
        data[index] = arr.get(i);
        generateCombinations(arr, numberOfElements, index + 1, data, i + 1, sums);
        generateCombinations(arr, numberOfElements, index, data, i + 1, sums);
        return sums;
    }
}
