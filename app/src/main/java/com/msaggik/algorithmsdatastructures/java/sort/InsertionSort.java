package com.msaggik.algorithmsdatastructures.java.sort;

/**
 * Сортировка ставками
 * <p>
 * Вычислительная сложность: О(N^2)
 * Затраты памяти: O(1)
 **/

public class InsertionSort {
    public static int[] insertionSort(int[] arrayInt) {
        for (int i = 1; i < arrayInt.length; i++) {
            int value = arrayInt[i];
            int j = i;
            while (true) {
                if(j > 0 && value < arrayInt[j - 1]) {
                    arrayInt[j] = arrayInt[j - 1];
                    j--;
                } else {
                    arrayInt[j] = value;
                    break;
                }
            }
        }
        return arrayInt;
    }
}
