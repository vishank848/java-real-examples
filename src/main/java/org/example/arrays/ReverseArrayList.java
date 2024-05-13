package org.example.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReverseArrayList {

    private ReverseArrayList() {
        throw new RuntimeException("This class cannot be instantiated.");
    }

    public static <T> void reverseWithRecursion(List<T> list) {
        if (list.size() > 1) {
            T value = list.removeFirst();
            reverseWithRecursion(list);
            list.add(value);
        }
    }

    public static <T> List<T> reverseWithLoop(List<T> list) {
        var lists = new ArrayList<T>();
        for (int i = 0, j = list.size() - 1; i < j; i++) {
            lists.add(i, list.remove(j));
        }
        return lists;
    }

    public static void main(String[] args) {
        ReverseArrayList.reverseWithLoop(Arrays.asList(1,2,3,4,5,6,7,8,9)).forEach(System.out::println);
        ReverseArrayList.reverseWithRecursion(Arrays.asList(1,2,3,4,5,6,7,8,9));
    }
}
