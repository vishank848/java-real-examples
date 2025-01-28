package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class TestSabre {

    public static void main(String[] args) {
        TestSabre testSabre = new TestSabre();
        Map<String, Long> map = testSabre.printOccurrence("ASASWEFDFasaa");
        map.forEach((k, v) -> System.out.println(k + " : " + v));
        testSabre.function();
        testSabre.listToMap();
    }

    public Map<String, Long> printOccurrence(String str) {
        TestSabre testSabre = new TestSabre();
//        if(str == null)
//            System.out.println("str cannot be null");

//        Arrays.stream(str.split(""))
//            .filter(e -> !e.isEmpty())
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//            .forEach((k, v) -> System.out.println(k + " : " + v));

//        Optional.ofNullable(str)
//            .orElseGet(String::new)
//            .codePoints().mapToObj(Character::toString)
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//            .forEach((k, v) -> System.out.println(k + " : " + v));

        return str == null || str.isEmpty() ? Map.of("empty or null string", 1L) : testSabre.print(str);
    }

    private Map<String, Long> print(String str) {
        return str.codePoints().mapToObj(Character::toString)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private void function() {
        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream());

        // Concatenated the list1 and list2 by converting them into Stream

        concatStream.forEach(str -> System.out.print(str + " "));

        // Printed the Concatenated Stream
    }

    private void listToMap() {
        List<Notes> noteLst = new ArrayList<>();
        noteLst.add(new Notes(1, "note1", 11));
        noteLst.add(new Notes(2, "note2", 22));
        noteLst.add(new Notes(3, "note3", 33));
        noteLst.add(new Notes(4, "note4", 44));
        noteLst.add(new Notes(5, "note5", 55));
        noteLst.add(new Notes(6, "note4", 66));

        Map<String, Long> notesRecords = noteLst.stream()
            .sorted(
                Comparator.comparingLong(Notes::getTagId).reversed()) // sorting is based on TagId 55,44,33,22,11
            .collect(
                Collectors.toMap(Notes::getTagName, Notes::getTagId,
                    (oldValue, newValue) -> oldValue, LinkedHashMap::new));
// consider old value 44 for dupilcate key
// it keeps order
        System.out.println("Notes : " + notesRecords);

//        List<Integer> numbers = List.of(3, 4, 3, 6, 8, 9, 4, 2, 2, 0);
        Map<String, Integer> map = Stream.of("bla", "blabla", "blablabla").distinct()
                .collect(Collectors.toMap(Function.identity(), String::length));
        map.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    @Getter
    @Setter
    @AllArgsConstructor
    private static class Notes {
        private int id;
        private String tagName;
        private long tagId;
    }


}
