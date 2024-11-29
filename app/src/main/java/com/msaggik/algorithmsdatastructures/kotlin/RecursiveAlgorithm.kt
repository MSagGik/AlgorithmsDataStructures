package com.msaggik.algorithmsdatastructures.kotlin

object RecursiveAlgorithm {
    fun calculationFactorial(value: Long): Long {
        if (value == 1L) return 1L
        return value * calculationFactorial(value - 1)
    }

    fun calculationValueFibonacci(index: Long): Long {
        if (index == 0L) return 0L
        if (index == 1L) return 1L
        return calculationValueFibonacci(index - 1) + calculationValueFibonacci(index - 2)
    }
}