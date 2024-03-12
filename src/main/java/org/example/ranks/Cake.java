package org.example.ranks;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Cake {
    public static void main(String[] args) {
        System.out.println(birthdayCakeCandles(Arrays.asList(4, 4, 1, 3)));
        System.out.println(birthdayCakeCandles(Arrays.asList(3, 2, 1, 3)));
    }

    public static int birthdayCakeCandle(List<Integer> candles) {
        // Write your code here
        int tallestCandles = 0;
        for (int i = 0; i < candles.size(); i++) {
            int maxCount = 0;
            for (Integer candle : candles) {
                if (Objects.equals(candles.get(i), candle)) {
                    maxCount++;
                }
            }
            if (tallestCandles < maxCount) {
                tallestCandles = maxCount;
            }
        }
        return tallestCandles;
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int maxHeight = Collections.max(candles);
        int count = 0;
        for (Integer height : candles) {
            if (height == maxHeight) {
                count++;
            }
        }
        return count;
    }
}
