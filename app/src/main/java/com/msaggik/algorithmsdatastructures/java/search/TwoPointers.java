package com.msaggik.algorithmsdatastructures.java.search;

/**
 * Метод двух указателей
 * применим к последовательности положительных отсортированных значений
 * Вычислительная сложность: О(N)
 * (к отсортированной смеси положительных и отрицательных значений также применим,
 * из-за наличия отрицательных значений алгоритм может быть лишь в 4 раза медленее)
 *
 * Пример: поиск наличия чисел сумма которых равняется "sum"
 **/

public class TwoPointers {
    public static boolean isSumNumbers(int[] arrayInt, int sum) {
        int left = 0, right = arrayInt.length - 1;
        while (left < right) {
            if (arrayInt[left] + arrayInt[right] == sum) return true;
            else if (arrayInt[left] + arrayInt[right] < sum) left++;
            else right--;
        }
        return false;
    }
}
