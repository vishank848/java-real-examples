package org.example.codeility;

/*
  Write a function solution that, given a string S consisting of N characters, returns the alphabetically
  smallest string that can be obtained by removing exactly one letter from S.
  Examples: 1. Given S = "acb", by removing one letter, you can obtain "ac", "ab" or "cb".
  Your function should return "ab" (after removing 'c') since it is alphabetically smaller than "ac" and "bc".
  2. Given S = "hot", your function should return "ho", which is alphabetically smaller than "ht" and "ot".
  3. Given S = "codility", your function should return "cdility", which can be obtained by removing the second letter. A
  4. Given S = "aaaa", your function should return "aaa". Any occurrence of 'a' can be removed.
  Write an efficient algorithm for the following assumptions: • N is an integer within the range [2..100,000];
  • string S is made only of lowercase letters (a-z).
 */

import java.util.HashSet;
import java.util.Set;

public class LongestFragmentSolution2 {

    public static int solution(int[] A) {
        int longestFragment = 0;  // Tracks the length of the longest consistent fragment
        int currentFragment = 0; // Tracks the current fragment length
        Set<Integer> digitSet = new HashSet<>(); // Tracks the two distinct digits encountered
        Integer prevDigit1; // Last seen digit 1
        Integer prevDigit2 = null; // Last seen digit 2

        for (int num : A) {
            if (!digitSet.contains(num)) {
                if (digitSet.size() == 2) {
                    // If already have two digits in the set, start a new fragment
                    prevDigit1 = prevDigit2;
                    prevDigit2 = num;

                    // Clear the set and add the new digit
                    digitSet.clear();
                    digitSet.add(prevDigit1);
                    digitSet.add(num);

                    // Reset current fragment length
                    currentFragment = 1;
                } else {
                    // Add the new digit if less than two digits in the set
                    digitSet.add(num);
                    currentFragment++;
                }
            } else {
                // If the number is already in the set, continue the current fragment
                currentFragment++;
            }

            // Update the longest fragment
            longestFragment = Math.max(longestFragment, currentFragment);
        }

        return longestFragment;
    }

    public static void main(String[] ignoredArgs) {
        int[] A = {4, 7, 4, 5, 8, 5, 5, 9};
        System.out.println(STR."Longest Fragment: \{solution(A)}"); // Output: 5
    }
}

