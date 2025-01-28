package org.example.codeility;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

class Java8Solution3 {
    public int longestConsistentFragment(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        // Use a mutable object to track state during stream processing
        class FragmentState {
            int maxFragmentLength = 0;
            int currentFragmentLength = 0;
            Set<Character> uniqueDigits = new HashSet<>();
        }

        FragmentState state = IntStream.of(A)
                .collect(
                        FragmentState::new, // Supplier to create the initial state
                        (fs, num) -> {
                            // Convert the current number to a string and get its unique digits
                            Set<Character> numDigits = Integer.toString(num)
                                    .chars()
                                    .mapToObj(c -> (char) c)
                                    .collect(HashSet::new, HashSet::add, HashSet::addAll);

                            // Check if the current number can be part of the current fragment
                            if (fs.uniqueDigits.containsAll(numDigits) || fs.uniqueDigits.size() + numDigits.size() <= 2) {
                                fs.uniqueDigits.addAll(numDigits); // Add the digits of the current number
                                fs.currentFragmentLength++; // Increase the current fragment length
                            } else {
                                // If more than two unique digits are found, update the longest fragment length
                                fs.maxFragmentLength = Math.max(fs.maxFragmentLength, fs.currentFragmentLength);
                                // Start a new fragment with the current number
                                fs.uniqueDigits = numDigits; // Set the current digits as the new unique digits set
                                fs.currentFragmentLength = 0; // Reset the fragment length to 1 for the current number
                            }
                        },
                        (fs1, fs2) -> {
                            // Combine logic for parallel streams (not needed here since we're not parallelizing)
                            fs1.maxFragmentLength = Math.max(fs1.maxFragmentLength, fs2.maxFragmentLength);
                            fs1.currentFragmentLength = Math.max(fs1.currentFragmentLength, fs2.currentFragmentLength);
                        }
                );

        // After processing the stream, check the last fragment
        state.maxFragmentLength = Math.max(state.maxFragmentLength, state.currentFragmentLength);

        return state.maxFragmentLength;
    }

    public static void main(String[] args) {
        Java8Solution3 solution = new Java8Solution3();

        // Example test cases
        int[] array1 = {23, 333, 33, 30, 0, 505};
        int[] array2 = {615, 88, 498, 99, 9};
        int[] array3 = {123, 456};

        System.out.println(solution.longestConsistentFragment(array1)); // Output: 4
        System.out.println(solution.longestConsistentFragment(array2)); // Output: 2
        System.out.println(solution.longestConsistentFragment(array3)); // Output: 0
    }
}