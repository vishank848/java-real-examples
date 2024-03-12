package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class RecordExample {
    public record Person(String name, String address) {
    }

    public record Person2(String name, String address) {
        public Person2 {
            Objects.requireNonNull(name);
            Objects.requireNonNull(address);
        }
    }

    public record Person3(String name, String address) {
        public Person3(String name) {
            this(name, "Unknown");
        }
    }

    public record Person4(String name, String address) {
        public Person4(String name, String address) {
            this.name = name;
            this.address = address;
        }
    }

    //this will not compile
//    public record Person5(String name, String address) {
//        public Person5 {
//            Objects.requireNonNull(name);
//            Objects.requireNonNull(address);
//        }
//
//        public Person5(String name, String address) {
//            this.name = name;
//            this.address = address;
//        }
//    }

    public record Person6(String name, String address) {
        public static String UNKNOWN_ADDRESS = "Unknown";
    }

    public record Person7(String name, String address) {
        public static Person7 unnamed(String address) {
            return new Person7("Unnamed", address);
        }
    }

    Person person = new Person("John Doe", "100 Linda Ln.");

    public static void main(String[] args) {
        String unknownAddress = Person6.UNKNOWN_ADDRESS;
        Person7.unnamed("100 Linda Ln.");

        List<String> sampleList = Arrays.asList("Java", "\n \n", "Kotlin", " ");
        List<String> withoutBlanks = sampleList.stream()
                .filter(Predicate.not(String::isBlank))
                .toList();
        withoutBlanks.forEach(System.out::println);
    }
}
