package org.example;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Persistent {

    public static void main(String[] args) {
        String str = "aabbcdde";

        Stream<String> stream = Arrays.stream(str.split(""));
        stream.forEach(System.out::println);

        //after java 8
        Character result =  str.chars()           // IntStream
                .mapToObj(i -> Character.toLowerCase((char) i))  // convert to lowercase & then to Character object Stream
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting())) // store in a LinkedHashMap with the count
                .entrySet().stream()                       // EntrySet stream
                .filter(entry -> entry.getValue() == 1L)   // extracts characters with a count of 1
                .map(Map.Entry::getKey)              // get the keys of EntrySet
                .findFirst().get();

        System.out.println(result);

        //old way before java 8

        int index = -1;
        char fnc = ' ';
        for (char i : str.toCharArray()) {
            if (str.indexOf(i) == str.lastIndexOf(i)) {
                fnc = i;
                break;
            }
            else {
                index += 1;
            }
        }
        if (index == 1) {
            System.out.println("Either all characters are repeating or "
                    + "string is empty");
        }
        else {
            System.out.println("First non-repeating character is " + fnc);
        }

    }
}
