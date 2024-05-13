package org.example.java8.deduplication;

import java.util.LinkedList;

public class LotsOfStrings {

    //run this class with vm option -Xmx256m -XX:+UseG1GC
    //then again run this class with vm option -Xmx256m -XX:+UseG1GC -XX:+UseStringDeduplication -XX:+PrintStringDeduplicationStatistics

    private static final LinkedList<String> LOTS_OF_STRINGS = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    LOTS_OF_STRINGS.add(new String("String " + j));
                }
            }
            iteration++;
            System.out.println("Survived Iteration: " + iteration);
            Thread.sleep(100);
        }
    }
}
