package org.example.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArrayChallenge {

    public static void main(String[] args) {
        System.out.println(treeConstructor(new String[]{"(1,2)", "(2,4)", "(5,7)", "(7,2)", "(9,5)"}));
        System.out.println(treeConstructor(new String[]{"(1,2)", "(3,2)", "(2,12)", "(5,2)"}));
    }

    public static String treeConstructor(String[] strArr) {
        Set<String> children = new HashSet<>();
        Map<String, Integer> parents = new HashMap<>();
        // Build a Set containing the child nodes, which will remove duplicates, and a Map of the parent nodes that
        // keeps track of the count of each parent.
        for (String node : strArr) {
            String[] values = node.replaceAll("[^0-9,]", "").split(",");
            children.add(values[0]);
            Integer count = parents.get(values[1]);
            // If a parent node has more than two child nodes, the tree is non-binary
            if (count != null && count + 1 > 2) {
                return "false";
            } else {
                parents.put(values[1], (count == null ? 1 : ++count));
            }
        }
        // If the size of the children Set, is less than the length of the input array, it means that the same child has
        // more than one parent, which makes the tree non-binary.
        return "" + (children.size() == strArr.length);
    }

}
