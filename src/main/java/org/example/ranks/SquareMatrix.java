package org.example.ranks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class    SquareMatrix {
    public static void main(String[] args) {
        List<List<Integer>> integerList = new ArrayList<>();
        List<Integer> integers1 = Arrays.asList(1, 2, 3);
        List<Integer> integers2 = Arrays.asList(4, 5, 6);
        List<Integer> integers3 = Arrays.asList(9, 8, 9);
        integerList.add(integers1);
        integerList.add(integers2);
        integerList.add(integers3);
        System.out.println(diagonalDifference(integerList));
        integerList.clear();
        List<Integer> integers4 = Arrays.asList(11, 2, 4);
        List<Integer> integers5 = Arrays.asList(4, 5, 6);
        List<Integer> integers6 = Arrays.asList(10, 8, -12);
        integerList.add(integers4);
        integerList.add(integers5);
        integerList.add(integers6);
        System.out.println(diagonalDifference(integerList));
    }

    private static int diagonalDifference(List<List<Integer>> arr) {
        int sumLeftToRight = 0;
        int sumRightToLeft = 0;
        int i = 0;
        int j = arr.getFirst().size() - 1;
        for (List<Integer> integers : arr) {
            while (i < integers.size()) {
                sumLeftToRight = sumLeftToRight + integers.get(i);
                break;
            }
            while (j >= 0) {
                sumRightToLeft = sumRightToLeft + integers.get(j);
                break;
            }
            i++;
            j--;
        }
        return Math.abs(sumLeftToRight - sumRightToLeft);
    }
}
