package org.example;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TestStream {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("one");

        Stream<String> stream = stringList.stream();

        Optional<String> reduced = stream.reduce((value, combinedValue) -> {
            return combinedValue + " + " + value;
        });
//        stream.forEach();

//        System.out.println(reduced.get());
    }
}
