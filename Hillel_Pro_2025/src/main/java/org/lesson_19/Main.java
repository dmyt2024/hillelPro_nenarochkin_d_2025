package org.lesson_19;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayUtils arr = new ArrayUtils();

        Random random = new Random();
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);

        }
        System.out.println("Unsorted array: " + Arrays.toString(array));

        // 1) MergeSort

        int[] sortedArray = arr.sort(array);
        System.out.println("Sorted array: " + Arrays.toString(sortedArray));

        System.out.println();

        // 2) BinarySearch

        int target = 71;
        int i = arr.binarySearch(sortedArray, target);
        System.out.println("Target index: " + i);
    }
}
