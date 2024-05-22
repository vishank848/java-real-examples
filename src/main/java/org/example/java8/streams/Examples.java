package org.example.java8.streams;

import java.util.Comparator;
import java.util.List;

public class Examples {
    public static void main(String[] args) {
        System.out.println(getAverage(List.of(1, 2, 3, 4, 5)));
        System.out.println(getUpperCase(List.of("aklsdk", "sdsd", "sdSdsdSSS")));
        System.out.println(getLowerCase(List.of("AKLSDK", "SDSD", "sdSdsdSSS")));
        System.out.println(getSumOfEvenNumbers(List.of(1, 2, 3, 4, 5)));
        System.out.println(getSumOfOddNumbers(List.of(1, 2, 3, 4, 5)));
        System.out.println(removeStringDuplicates(List.of("Ram", "Shyam", "Ram", "Kush", "Sita", "Love", "Shyam")));
        System.out.println(removeIntegerDuplicates(List.of(10, 23, 22, 23, 24, 24, 33, 15, 26, 15)));
        countWordsStartsWithSpecificCharacter(List.of("Red", "Green", "Blue", "Pink", "Brown"), "B");
        countWordsStartsWithSpecificCharacter(List.of("Red", "Green", "Blue", "Pink", "Brown"), "Y");
        System.out.println(sortingAscendingOrder(List.of("Red", "Green", "Blue", "Pink", "Brown")));
        System.out.println(sortingDescendingOrder(List.of("Red", "Green", "Blue", "Pink", "Brown")));
    }

    private static double getAverage(List<Integer> numbers) {
        //Write a Java program to calculate the average of a list of integers using streams.
        return numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }

    private static List<String> getUpperCase(List<String> strings) {
        //Write a Java program to convert a list of strings to uppercase using streams.
        return strings.stream().map(String::toUpperCase).toList();
    }

    private static List<String> getLowerCase(List<String> strings) {
        //Write a Java program to convert a list of strings to lowercase using streams.
        return strings.stream().map(String::toLowerCase).toList();
    }

    private static Integer getSumOfEvenNumbers(List<Integer> numbers) {
        //Write a Java program to calculate the sum of all even numbers in a list using streams
        return numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    private static Integer getSumOfOddNumbers(List<Integer> numbers) {
        //Write a Java program to calculate the sum of all odd numbers in a list using streams
        return numbers.stream().filter(num -> num % 2 != 0).mapToInt(Integer::intValue).sum();
    }

    private static List<String> removeStringDuplicates(List<String> strings) {
        //Write a Java program to remove all duplicate elements from a list using streams.
        return strings.stream().distinct().toList();
    }

    private static List<Integer> removeIntegerDuplicates(List<Integer> integers) {
        //Write a Java program to remove all duplicate elements from a list using streams.
        return integers.stream().distinct().toList();
    }

    private static void countWordsStartsWithSpecificCharacter(List<String> strings, String startsWith) {
        //Write a Java program to count the number of strings in a list that start with a specific letter using streams.
        System.out.println("Number of String starting with " + startsWith + " : " 
            + strings.stream().filter(s -> s.startsWith(startsWith)).count());
    }
    
    private static List<String> sortingAscendingOrder(List<String> strings) {
        //Write a Java program to sort a list of strings in alphabetical order ascending using streams.
        return strings.stream().sorted().toList();
    }

    private static List<String> sortingDescendingOrder(List<String> strings) {
        //Write a Java program to sort a list of strings in alphabetical order descending using streams.
        return strings.stream().sorted(Comparator.reverseOrder()).toList();
    }

}
