package com.msaggik.algorithms.kotlin.sort

object HeapSort {
    fun heapSort(arrayInt: IntArray): IntArray {
        // heap creation
        for (i in arrayInt.size / 2 - 1 downTo 0) {
            createHeap(arrayInt, i, arrayInt.size)
        }
        // building an array from the heap
        for (i in arrayInt.indices.reversed()) {
            val value = arrayInt[0]
            arrayInt[0] = arrayInt[i]
            arrayInt[i] = value
            createHeap(arrayInt, 0, i)
        }
        return arrayInt
    }

    private fun createHeap(array: IntArray, root: Int, length: Int) {
        val left = 2 * root + 1
        val right = 2 * root + 2
        var middle = root

        if (left < length && array[left] > array[middle]) middle = left
        if (right < length && array[right] > array[middle]) middle = right

        if (middle != root) {
            val value = array[middle]
            array[middle] = array[root]
            array[root] = value

            createHeap(array, middle, length)
        }
    }
}