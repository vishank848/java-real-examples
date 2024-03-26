package org.example.string.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharactersFrequency {
    public static void main(String[] args) {
        countCharactersFrequency(Arrays.asList("Pen", "Pencil", "Eraser", "Pen", "Eraser", "Child", "Pencil", "Pen"));
    }

    private static void countCharactersFrequency(List<String> strings) {
        Map<Character, Integer> stringIntegerMap = new HashMap<>();
        for (String string : strings) {
            for (int l = 0; l < string.length(); l++) {
                char c = string.charAt(l);
                Integer num = stringIntegerMap.get(c);
                num = (num == null) ? 1 : ++num;
                stringIntegerMap.put(c, num);
            }
        }
        stringIntegerMap.forEach((k, v) -> System.out.println(STR."\{k} : \{v}"));
    }
}
