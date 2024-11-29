package com.msaggik.algorithmsdatastructures.java.sort;

/**
 * Сортировка ставками
 * <p>
 * Вычислительная сложность: средняя О(N*log(N)), худшая О(N^2)
 * Затраты памяти: средняя О(log(N)), худшая О(N)
 **/

public class QuickSort {
    public static int[] quickSort(int[] arrayInt) {
        if (arrayInt.length < 2) return arrayInt;

        int left = 0, right = arrayInt.length - 1;
        quickSortBase(arrayInt, left, right);

        return arrayInt;
    }

    private static void quickSortBase(int[] arrayInt, int left, int right) {
        if (left >= right) return;

        int indexMiddle = (left + right) / 2;
        int middle = arrayInt[indexMiddle];
        int l = left;
        int r = right;
        while (l <= r) {
            while (arrayInt[l] < middle) l++;
            while (arrayInt[r] > middle) r--;
            if (l <= r) {
                int value = arrayInt[l];
                arrayInt[l] = arrayInt[r];
                arrayInt[r] = value;
                l++;
                r--;
            }
        }

        if (left < r) quickSortBase(arrayInt, left, r);
        if (right > l) quickSortBase(arrayInt, l, right);
    }
}