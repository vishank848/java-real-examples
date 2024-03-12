package org.example.ranks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareArray {
    public static void main(String[] args) {
        System.out.println(compareTriplets(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1)));
        System.out.println(compareTriplets(Arrays.asList(5, 6, 7), Arrays.asList(3, 6, 10)));
        System.out.println(compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8)));
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        if (a.size() != b.size()) {
            return null;
        }
        int countA = 0;
        int countB = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i)) {
                countA++;
            } else if (a.get(i) < b.get(i)) {
                countB++;
            }
        }
        result.add(countA);
        result.add(countB);
        return result;
    }
}
