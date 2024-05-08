package org.example;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TestSabre {

    public static void main(String[] args) {
        Map<String, Long> map = new TestSabre().printOccurrence("ASASWEFDFasaa");
        map.forEach((k,v) -> System.out.println(k + " : " + v));
    }

    public Map<String, Long> printOccurrence(String str) {
        TestSabre testSabre = new TestSabre();
//        if(str == null)
//            System.out.println("str cannot be null");

//        Arrays.stream(str.split(""))
//            .filter(e -> !e.isEmpty())
//            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
//            .forEach((k, v) -> System.out.println(k + " : " + v));
        return str == null || str.isEmpty() ? Map.of("empty or null string", 1L) : testSabre.print(str);
    }

    private Map<String, Long> print(String str) {
        return str.codePoints().mapToObj(Character::toString)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


}
