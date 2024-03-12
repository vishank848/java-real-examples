package org.example.ranks;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class IntegerRemovalArray {
    public static void main(String[] args) {
        System.out.println(gameArray(Arrays.asList(2, 3, 5, 4, 1)));
        System.out.println(gameArray(Arrays.asList(5, 2, 6, 3, 4)));
        System.out.println(gameArray(Arrays.asList(3, 1)));
        System.out.println(gameArray(Arrays.asList(1, 3, 5, 7, 9)));
        System.out.println(gameArray(Arrays.asList(7, 4, 6, 5, 9)));
        System.out.println(gameArray(Arrays.asList(5, 3, 7)));
    }

    private static String gameArray(List<Integer> arr) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < arr.size(); i++) {
            tm.put(arr.get(i), i);
        }
        int lastIndex = arr.size();
        int ans = 0;
        while (!tm.isEmpty()) {
            Map.Entry<Integer, Integer> e = tm.pollLastEntry();
            if (e.getValue() < lastIndex) {
                lastIndex = e.getValue();
                ans++;
            }
        }
        return ans % 2 == 0 ? "ANDY" : "BOB";
    }
}
