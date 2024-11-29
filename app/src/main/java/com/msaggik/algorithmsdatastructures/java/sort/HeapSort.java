package com.msaggik.algorithmsdatastructures.java.sort;

/**
 * Пирамидальная сортировка
 * <p>
 * Вычислительная сложность: О(N*log(N))
 * Затраты памяти: O(1)
 **/

public class HeapSort {
    public static int[] heapSort(int[] arrayInt) {
        // heap creation
        for(int i = arrayInt.length / 2 - 1; i >= 0; i--) {
            createHeap(arrayInt, i, arrayInt.length);
        }
        // building an array from the heap
        for(int i = arrayInt.length - 1; i >= 0; i--) {
            int value = arrayInt[0];
            arrayInt[0] = arrayInt[i];
            arrayInt[i] = value;
            createHeap(arrayInt, 0, i);
        }
        return arrayInt;
    }

    private static void createHeap(int[] array, int root, int length) {
        int left = 2 * root + 1;
        int right = 2 * root + 2;
        int middle = root;

        if (left < length && array[left] > array[middle]) middle = left;
        if (right < length && array[right] > array[middle]) middle = right;

        if (middle != root)  {
            int value = array[middle];
            array[middle] = array[root];
            array[root] = value;

            createHeap(array, middle, length);
        }
    }
}
