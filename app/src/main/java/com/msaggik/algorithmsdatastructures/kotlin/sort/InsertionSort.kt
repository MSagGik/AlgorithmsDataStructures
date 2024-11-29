package com.msaggik.algorithms.kotlin.sort

object InsertionSort {
    fun insertionSort(arrayInt: IntArray): IntArray {
        for (i in 1 until arrayInt.size) {
            val value = arrayInt[i]
            var j = i
            while (true) {
                if (j > 0 && value < arrayInt[j - 1]) {
                    arrayInt[j] = arrayInt[j - 1]
                    j--
                } else {
                    arrayInt[j] = value
                    break
                }
            }
        }
        return arrayInt
    }
}