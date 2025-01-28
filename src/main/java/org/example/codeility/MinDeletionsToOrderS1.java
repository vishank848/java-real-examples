package org.example.codeility;

/**
 * We are given a string S of length N consisting only of letters 'A' and/or 'B'.
 * Our goal is to obtain a string in the format "A...AB...B" (all letters 'A' occur before all letters 'B')
 * by deleting some letters from S.
 * In particular, strings consisting only of letters 'A' or only of letters 'B' fit this format.
 * Write a function:
 * def solution(S):that, given a string S , returns the minimum number of letters that
 * need to be deleted from S in order to obtain a string in the above format.
 * Examples:
 * 1. Given S="BAAABAB" , the function should return 2.
 * We can obtain "AAABB" by deleting the first occurrence of 'B' and the last occurrence of 'A'.
 * 2. Given S="BBABAA" , the function should return 3.
 * We can delete all occurrences of 'A' or all occurrences of 'B'.
 * 3. Given S="AABBBB" , the function should return 0.
 * The given string is already in the correct format.
 */

public class MinDeletionsToOrderS1 {

    public static int minDeletions(String S) {
        // Step 1: Count total 'A's and 'B's
        int totalA = 0, totalB = 0;
        for (char c : S.toCharArray()) {
            if (c == 'A') totalA++;
            else if (c == 'B') totalB++;
        }

        // Step 2: Find the optimal arrangement
        int aCount = 0; // Count of 'A's encountered so far
        int bCount = 0; // Count of 'B's encountered so far
        int minDeletions = Integer.MAX_VALUE;

        for (char c : S.toCharArray()) {
            if (c == 'A') {
                aCount++;
            } else if (c == 'B') {
                bCount++;
            }

            // Deletions needed: 'B's before the current point + 'A's after the current point
            int deletions = bCount + (totalA - aCount);
            minDeletions = Math.min(minDeletions, deletions);
        }

        // Final result
        return minDeletions;
    }

    public static void main(String[] args) {
        System.out.println("Minimum deletions: " + minDeletions("ABBAA")); // Output: 2
        System.out.println("Minimum deletions: " + minDeletions("BAAABAB")); // Output: 2
        System.out.println("Minimum deletions: " + minDeletions("BBABAA")); // Output: 2
        System.out.println("Minimum deletions: " + minDeletions("AABBBB")); // Output: 2
    }
}
