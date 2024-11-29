package com.msaggik.algorithmsdatastructures.java.search;

/**
 * Бинарный поиск
 * применим к последовательности отсортированных значений
 * Вычислительная сложность: О(log(N))
 * <p>
 * Пример: поиск значения в массиве
 * (если имеется возвращает его индекс, если отсутствует возвращает -1)
 **/

public class BinarySearch {
    public static int isValueInArray(int[] arrayInt, int value) {
        int left = 0, right = arrayInt.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int current = arrayInt[middle];
            if (current == value) return middle;
            else if (current < value) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
