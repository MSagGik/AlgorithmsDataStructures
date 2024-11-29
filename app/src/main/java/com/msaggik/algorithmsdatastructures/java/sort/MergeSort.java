package com.msaggik.algorithmsdatastructures.java.sort;

/**
 * Сортировка слиянием
 * <p>
 * Вычислительная сложность: О(N*log(N))
 * Затраты памяти: О(N)
 **/

public class MergeSort {
    public static int[] mergeSort(int[] arrayInt) {
        int length = arrayInt.length;

        mergeSortBase(arrayInt, length);

        return arrayInt;
    }

    private static void mergeSortBase(int[] arrayInt, int length) {
        if(length < 2) return;

        int indexMiddle = length / 2;
        int leftLength = indexMiddle, rightLength = length - indexMiddle;

        // division into 2 arrays
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for (int i = 0; i < length; i++) {
            if(i < indexMiddle) leftArray[i] = arrayInt[i];
            else rightArray[i - indexMiddle] = arrayInt[i];
        }

        // recursive further division
        mergeSortBase(leftArray, leftLength);
        mergeSortBase(rightArray, rightLength);

        // merge arrays
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            arrayInt[k++] = (leftArray[i] <= rightArray[j]) ? leftArray[i++] : rightArray[j++];
        }
        while (i < leftLength) arrayInt[k++] = leftArray[i++];
        while (j < rightLength) arrayInt[k++] = rightArray[j++];
    }
}