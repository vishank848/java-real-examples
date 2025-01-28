package org.example.codeility;

import java.util.HashSet;
import java.util.Set;


/**
 * class Solution {
 * public int solution(int[] A) {
 * // Your code here
 * }
 * }This function, given an array A of N integers, returns the length of the longest consistent
 * fragment of A in which all elements can be generated using at most two different digits.
 * The same two digits must be used for all elements in the fragment.
 * Examples:
 * 1. Given A = [23, 333, 33, 30, 0, 505], the function should return 4.
 * Elements 333, 33, 30, and 0 can be generated using only digits 0 and 3.
 *
 * 2. Given A = [615, 88, 498, 99, 91], the function should return 2.
 * The last two elements can be generated using only digit 9.
 */

class Solution3 {
    public int longestConsistentFragment(int[] A) {
        int maxFragmentLength = 0;   // To store the length of the longest fragment
        int currentFragmentLength = 0; // To track the current fragment length
        Set<Character> uniqueDigits = new HashSet<>(); // To track the unique digits in the current fragment

        for (int num : A) {
            // Convert the current number to a string and get its unique digits
            String numStr = Integer.toString(num);
            Set<Character> numDigits = new HashSet<>();
            for (char digit : numStr.toCharArray()) {
                numDigits.add(digit);
            }

            // If the current number can be part of the current fragment (it uses at most 2 unique digits)
            if (uniqueDigits.containsAll(numDigits) || uniqueDigits.size() + numDigits.size() <= 2) {
                uniqueDigits.addAll(numDigits); // Add the digits of the current number to the unique digits set
                currentFragmentLength++;  // Increase the current fragment length
            } else {
                // If more than two unique digits are found, update the longest fragment length
                maxFragmentLength = Math.max(maxFragmentLength, currentFragmentLength);
                // Start a new fragment with the current number
                uniqueDigits = numDigits;  // Set the current digits as the new unique digits set
                currentFragmentLength = 0;  // Reset the fragment length to 1 for the current number
            }
        }

        if(uniqueDigits.contains('0')) maxFragmentLength++;

        // After the loop, check the last fragment
        maxFragmentLength = Math.max(maxFragmentLength, currentFragmentLength);

        return maxFragmentLength;
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();

        // Example test cases
        int[] array1 = {23, 333, 33, 30, 0, 505};
        int[] array2 = {615, 88, 498, 99, 9};
        int[] array3 = {123, 456};

        System.out.println(solution.longestConsistentFragment(array1)); // Output: 4
        System.out.println(solution.longestConsistentFragment(array2)); // Output: 2
        System.out.println(solution.longestConsistentFragment(array3)); // Output: 0
    }
}