# [Алгоритмы](../../)

## Пирамидальная сортировка

### Применимость:

Для сортировки средних и больших последовательностей

### Вычислительная сложность:

`О(N*log(N))`

### Затраты памяти:

`О(1)`

### Пример:

- Java:

``` Java
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
```
- Kotlin:
``` Kotlin
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
```
### Примеры тестов:

- Java:
``` Java
public class HeapSortTest {
    private final int[] arrayTestOne = {123, -10, 0, 1, -5, 1000, 321, 2, 0, 11};
    private final int[] arrayTestSortOne = {-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000};
    private final int[] arrayTestTwo = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
    private final int[] arrayTestSortTwo = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test(timeout = 100)
    public void testHeapSortOne() {
        int[] result = HeapSort.heapSort(arrayTestOne);
        Assert.assertArrayEquals(result, arrayTestSortOne);
    }

    @Test(timeout = 100)
    public void testHeapSortTwo() {
        int[] result = HeapSort.heapSort(arrayTestTwo);
        Assert.assertArrayEquals(result, arrayTestSortTwo);
    }
}
```
- Kotlin:
``` Kotlin
class HeapSortTest {
    private val arrayTestOne = intArrayOf(123, -10, 0, 1, -5, 1000, 321, 2, 0, 11)
    private val arrayTestSortOne = intArrayOf(-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000)
    private val arrayTestTwo = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5)
    private val arrayTestSortTwo = intArrayOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test(timeout = 100)
    fun testHeapSortOne() {
        val result = HeapSort.heapSort(arrayTestOne)
        Assert.assertArrayEquals(result, arrayTestSortOne)
    }

    @Test(timeout = 100)
    fun testHeapSortTwo() {
        val result = HeapSort.heapSort(arrayTestTwo)
        Assert.assertArrayEquals(result, arrayTestSortTwo)
    }
}
```