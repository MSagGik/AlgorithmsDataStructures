package com.msaggik.algorithmsdatastructures.java.sort;

/**
 * Сортировка "Пузырьком"
 * <p>
 * Вычислительная сложность: О(N^2)
 * Затраты памяти: O(1)
 **/

public class BubbleSort {

    public static int[] bubbleSort(int[] arrayInt) {
        for (int i = 0; i < arrayInt.length - 1; i++)
            for (int j = i + 1; j < arrayInt.length; j++) {
                if(arrayInt[i] > arrayInt[j]) {
                    int value = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = value;
                }
            }
        return arrayInt;
    }
}
