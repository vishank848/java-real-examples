package org.example.java8;

import java.util.List;
import java.util.stream.IntStream;

public class ListSplitter {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 4, 3, 6, 8, 9, 4, 2, 2, 0);
        splitter(numbers, 3).forEach(System.out::println);
        Integer i = numbers.stream().sorted().skip(1).findFirst().orElse(null);
        System.out.println(i);
    }

    private static List<List<Integer>> splitter(List<Integer> numbers, int i) {
        return IntStream.iterate(0, n -> n < numbers.size(), n -> n + i)
                .mapToObj(n -> numbers.subList(n, Math.min(n + i, numbers.size())))
                .toList();
    }
}
