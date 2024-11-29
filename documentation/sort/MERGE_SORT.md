# [Алгоритмы](../../)

## Сортировка слиянием

### Применимость:

Для сортировки средних и больших последовательностей

### Вычислительная сложность:

`О(N*log(N))`

### Затраты памяти:

`О(N)`

### Пример:

- Java:

``` Java
public class MergeSort {
    public static int[] mergeSort(int[] arrayInt) {
        int length = arrayInt.length;

        mergeSortBase(arrayInt, length);

        return arrayInt;
    }

    private static void mergeSortBase(int[] arrayInt, int length) {
        if(length < 2) return;

        int indexMiddle = length / 2;
        int leftLength = indexMiddle, rightLength = length - indexMiddle;

        // division into 2 arrays
        int[] leftArray = new int[leftLength];
        int[] rightArray = new int[rightLength];

        for (int i = 0; i < length; i++) {
            if(i < indexMiddle) leftArray[i] = arrayInt[i];
            else rightArray[i - indexMiddle] = arrayInt[i];
        }

        // recursive further division
        mergeSortBase(leftArray, leftLength);
        mergeSortBase(rightArray, rightLength);

        // merge arrays
        int i = 0, j = 0, k = 0;
        while (i < leftLength && j < rightLength) {
            arrayInt[k++] = (leftArray[i] <= rightArray[j]) ? leftArray[i++] : rightArray[j++];
        }
        while (i < leftLength) arrayInt[k++] = leftArray[i++];
        while (j < rightLength) arrayInt[k++] = rightArray[j++];
    }
}
```
- Kotlin:
``` Kotlin
object MergeSort {
    fun mergeSort(arrayInt: IntArray): IntArray {
        val length = arrayInt.size

        mergeSortBase(arrayInt, length)

        return arrayInt
    }

    private fun mergeSortBase(arrayInt: IntArray, length: Int) {
        if (length < 2) return

        val indexMiddle = length / 2
        val leftLength = indexMiddle
        val rightLength = length - indexMiddle

        // division into 2 arrays
        val leftArray = IntArray(leftLength)
        val rightArray = IntArray(rightLength)

        for (i in 0 until length) {
            if (i < indexMiddle) leftArray[i] = arrayInt[i]
            else rightArray[i - indexMiddle] = arrayInt[i]
        }

        // recursive further division
        mergeSortBase(leftArray, leftLength)
        mergeSortBase(rightArray, rightLength)

        // merge arrays
        var i = 0
        var j = 0
        var k = 0
        while (i < leftLength && j < rightLength) {
            arrayInt[k++] = if (leftArray[i] <= rightArray[j]) leftArray[i++] else rightArray[j++]
        }
        while (i < leftLength) arrayInt[k++] = leftArray[i++]
        while (j < rightLength) arrayInt[k++] = rightArray[j++]
    }
}
```
### Примеры тестов:

- Java:
``` Java
public class MergeSortTest {
    private final int[] arrayTestOne = {123, -10, 0, 1, -5, 1000, 321, 2, 0, 11};
    private final int[] arrayTestSortOne = {-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000};
    private final int[] arrayTestTwo = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
    private final int[] arrayTestSortTwo = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test(timeout = 100)
    public void testMergeSortOne() {
        int[] result = MergeSort.mergeSort(arrayTestOne);
        Assert.assertArrayEquals(result, arrayTestSortOne);
    }

    @Test(timeout = 100)
    public void testMergeSortTwo() {
        int[] result = MergeSort.mergeSort(arrayTestTwo);
        Assert.assertArrayEquals(result, arrayTestSortTwo);
    }
}
```
- Kotlin:
``` Kotlin
class MergeSortTest {
    private val arrayTestOne = intArrayOf(123, -10, 0, 1, -5, 1000, 321, 2, 0, 11)
    private val arrayTestSortOne = intArrayOf(-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000)
    private val arrayTestTwo = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5)
    private val arrayTestSortTwo = intArrayOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test(timeout = 100)
    fun testMergeSortOne() {
        val result = MergeSort.mergeSort(arrayTestOne)
        Assert.assertArrayEquals(result, arrayTestSortOne)
    }

    @Test(timeout = 100)
    fun testMergeSortTwo() {
        val result = MergeSort.mergeSort(arrayTestTwo)
        Assert.assertArrayEquals(result, arrayTestSortTwo)
    }
}
```