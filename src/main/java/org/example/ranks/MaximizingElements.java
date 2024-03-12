package org.example.ranks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MaximizingElements {
    public static void main(String[] args) {
        System.out.println(getMaxValue(Arrays.asList(3, 1, 3, 4)));
        System.out.println(getMaxValue(Arrays.asList(1, 3, 2, 2)));
        System.out.println(getMaxValue(Arrays.asList(4, 3, 2, 3, 5)));
    }

    public static int getMaxValue(List<Integer> arr) {
        // Write your code here
        List<Integer> collect = arr.stream().sorted().collect(Collectors.toList());
        if (collect.getFirst() != 1) {
            collect.set(0, 1);
        }
        for (int i = 1; i < collect.size(); i++) {
            if (collect.get(i) - collect.get(i - 1) > 1) {
                collect.set(i, collect.get(i - 1) + 1);
            }
        }
        return collect.getLast();
    }
}
