package org.example.string.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.google.common.collect.Streams;

public class CharactersOccurencs {

    public static void main(String[] args) {
//        String str = "ssdsfwefsvdadcvdffassaass";
//
//        str.codePoints().mapToObj(Character::toString)
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//            .forEach((k, v) -> System.out.println(STR."\{k} : \{v}"));

        List<Integer> integers = List.of(3, 1, 5, 0, 7, 9, 3, 9, 2);
        Optional<Integer> first =
            integers.stream().sorted(Comparator.naturalOrder()).toList().stream().findFirst();
        first.ifPresent(System.out::println);

        Optional<Integer> maxNumber = integers.stream()
            .max(Integer::compareTo);
        maxNumber.ifPresent(System.out::println);
        Optional<Integer> first1 = integers.stream().distinct()
            .sorted(Comparator.reverseOrder()).skip(1).findFirst();
        first1.ifPresent(System.out::println);

        List<String> valueList = new ArrayList<>();
        valueList.add("Joe");
        valueList.add("John");
        valueList.add("Sean");

        Stream<String> stream = valueList.stream();
        String s = stream.reduce((first2, second) -> second)
            .orElse(null);
        System.out.println(s);
        integers.stream().reduce((_, l) -> l).ifPresent(System.out::println);
        findLastMethod();
    }
    
    private static void findLastMethod() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9)
            .stream();

        Integer lastElement = Streams.findLast(stream).orElse(-1);

        System.out.println(lastElement);
    }
}
