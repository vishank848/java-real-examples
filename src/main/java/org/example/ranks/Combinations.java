package org.example.ranks;

public class Combinations {
    static void generateCombinations(int[] arr, int arrLength, int numberOfElements, int index,
                                     int[] data, int i) {
        if (index == numberOfElements) {
            for (int j = 0; j < numberOfElements; j++)
                System.out.print(data[j] + " ");
            System.out.println(" ");
            return;
        }
        if (i >= arrLength)
            return;

        data[index] = arr[i];
        generateCombinations(arr, arrLength, numberOfElements, index + 1, data, i + 1);
        generateCombinations(arr, arrLength, numberOfElements, index, data, i + 1);
    }

    static void printCombination(int[] arr, int arrLength, int numberOfElements) {
        int[] data = new int[numberOfElements];
        generateCombinations(arr, arrLength, numberOfElements, 0, data, 0);
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int numberOfElements = 4;
        int arrLength = arr.length;
        printCombination(arr, arrLength, numberOfElements);
    }
}
