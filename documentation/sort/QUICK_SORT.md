# [Алгоритмы](../../)

## Быстрая сортировка

### Применимость:

Для сортировки средних и больших последовательностей

### Вычислительная сложность:

средняя `О(N*log(N))`, худшая `О(N^2)`

### Затраты памяти:

средняя `О(log(N))`, худшая `О(N)`

### Пример:

- Java:

``` Java
public class QuickSort {
    public static int[] quickSort(int[] arrayInt) {
        if (arrayInt.length < 2) return arrayInt;

        int left = 0, right = arrayInt.length - 1;
        quickSortBase(arrayInt, left, right);

        return arrayInt;
    }

    private static void quickSortBase(int[] arrayInt, int left, int right) {
        if (left >= right) return;

        int indexMiddle = (left + right) / 2;
        int middle = arrayInt[indexMiddle];
        int l = left;
        int r = right;
        while (l <= r) {
            while (arrayInt[l] < middle) l++;
            while (arrayInt[r] > middle) r--;
            if (l <= r) {
                int value = arrayInt[l];
                arrayInt[l] = arrayInt[r];
                arrayInt[r] = value;
                l++;
                r--;
            }
        }

        if (left < r) quickSortBase(arrayInt, left, r);
        if (right > l) quickSortBase(arrayInt, l, right);
    }
}
```
- Kotlin:
``` Kotlin
object QuickSort {
    fun quickSort(arrayInt: IntArray): IntArray {
        if (arrayInt.size < 2) return arrayInt

        val left = 0
        val right = arrayInt.size - 1
        quickSortBase(arrayInt, left, right)

        return arrayInt
    }

    private fun quickSortBase(arrayInt: IntArray, left: Int, right: Int) {
        if (left >= right) return

        val indexMiddle = (left + right) / 2
        val middle = arrayInt[indexMiddle]
        var l = left
        var r = right
        while (l <= r) {
            while (arrayInt[l] < middle) l++
            while (arrayInt[r] > middle) r--
            if (l <= r) {
                val value = arrayInt[l]
                arrayInt[l] = arrayInt[r]
                arrayInt[r] = value
                l++
                r--
            }
        }

        if (left < r) quickSortBase(arrayInt, left, r)
        if (right > l) quickSortBase(arrayInt, l, right)
    }
}
```
### Примеры тестов:

- Java:
``` Java
public class QuickSortTest {
    private final int[] arrayTestOne = {123, -10, 0, 1, -5, 1000, 321, 2, 0, 11};
    private final int[] arrayTestSortOne = {-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000};
    private final int[] arrayTestTwo = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
    private final int[] arrayTestSortTwo = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test(timeout = 100)
    public void testQuickSortOne() {
        int[] result = QuickSort.quickSort(arrayTestOne);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(result, arrayTestSortOne);
    }

    @Test(timeout = 100)
    public void testQuickSortTwo() {
        int[] result = QuickSort.quickSort(arrayTestTwo);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(result, arrayTestSortTwo);
    }
}
```
- Kotlin:
``` Kotlin
class QuickSortTest {
    private val arrayTestOne = intArrayOf(123, -10, 0, 1, -5, 1000, 321, 2, 0, 11)
    private val arrayTestSortOne = intArrayOf(-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000)
    private val arrayTestTwo = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5)
    private val arrayTestSortTwo = intArrayOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test(timeout = 100)
    fun testQuickSortOne() {
        val result = QuickSort.quickSort(arrayTestOne)
        Assert.assertArrayEquals(result, arrayTestSortOne)
    }

    @Test(timeout = 100)
    fun testQuickSortTwo() {
        val result = QuickSort.quickSort(arrayTestTwo)
        Assert.assertArrayEquals(result, arrayTestSortTwo)
    }
}
```