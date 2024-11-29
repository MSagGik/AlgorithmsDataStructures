package com.msaggik.algorithms.kotlin.sort

object BubbleSort {
    fun bubbleSort(arrayInt: IntArray): IntArray {
        for (i in 0 until arrayInt.size - 1) for (j in i + 1 until arrayInt.size) {
            if (arrayInt[i] > arrayInt[j]) {
                val value = arrayInt[i]
                arrayInt[i] = arrayInt[j]
                arrayInt[j] = value
            }
        }
        return arrayInt
    }
}