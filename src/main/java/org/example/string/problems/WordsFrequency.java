package org.example.string.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class WordsFrequency {

    public static void main(String[] args) {
        countWordsFrequency(Arrays.asList("Pen", "Pencil", "Eraser", "Pen", "Eraser", "Child", "Pencil", "Pen"));
        countWordsFrequencyUsingConcurrency(Arrays.asList("Pen", "Pencil", "Eraser", "Pen", "Eraser", "Child", "Pencil", "Pen"));
    }

    private static void countWordsFrequency(List<String> strings) {
        Map<String, Integer> stringIntegerMap = new HashMap<>();
        for (String string : strings) {
            Integer num = stringIntegerMap.get(string);
            num = (num == null) ? 1 : ++num;
            stringIntegerMap.put(string, num);
        }
        stringIntegerMap.forEach((k, v) -> System.out.println(STR."\{k} : \{v}"));
    }

    private static void countWordsFrequencyUsingConcurrency(List<String> strings) {
        System.out.println("--------------------------------------------------");
        ConcurrentMap<String, Integer> m = new ConcurrentHashMap<>();
        for (String string : strings) {
            m.compute(string, (k, v) -> v == null ? 1 : v + 1);
        }
        m.forEach((k, v) -> System.out.println(STR."\{k} : \{v}"));
    }
}
