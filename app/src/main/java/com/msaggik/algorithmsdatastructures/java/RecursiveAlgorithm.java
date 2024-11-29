package com.msaggik.algorithmsdatastructures.java;

/**
 * Рекурсивный алгоритм
 * применим к задачам, которые можно разбить на одинаковые повторяющиеся действия
 * <p>
 * Алгоритм действий:
 * 1) определяются уникальные начальные условия (с выходом из рекурсии)
 * 2) запуск рекурсии
 **/

public class RecursiveAlgorithm {

    public static long calculationFactorial(long value) {
        if(value == 1) return 1L;
        return value * calculationFactorial(value - 1);
    }

    public static long calculationValueFibonacci(long index) {
        if(index == 0) return 0L;
        if(index == 1) return 1L;
        return calculationValueFibonacci(index - 1) + calculationValueFibonacci(index - 2);
    }
}
