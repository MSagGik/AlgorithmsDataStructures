# [Алгоритмы](../../)

## Сортировка вставками

### Применимость:

Для сортировки малых последовательностей

### Вычислительная сложность:

`O(N^2)`
### Затраты памяти:

`O(1)`

### Пример:

- Java:

``` Java
public class InsertionSort {
    public static int[] insertionSort(int[] arrayInt) {
        for (int i = 1; i < arrayInt.length; i++) {
            int value = arrayInt[i];
            int j = i;
            while (true) {
                if(j > 0 && value < arrayInt[j - 1]) {
                    arrayInt[j] = arrayInt[j - 1];
                    j--;
                } else {
                    arrayInt[j] = value;
                    break;
                }
            }
        }
        return arrayInt;
    }
}
```
- Kotlin:
``` Kotlin
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
```
### Примеры тестов:

- Java:
``` Java
public class InsertionSortTest {
    private final int[] arrayTestOne = {123, -10, 0, 1, -5, 1000, 321, 2, 0, 11};
    private final int[] arrayTestSortOne = {-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000};
    private final int[] arrayTestTwo = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5};
    private final int[] arrayTestSortTwo = {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    @Test(timeout = 100)
    public void testInsertionSortOne() {
        int[] result = InsertionSort.insertionSort(arrayTestOne);
        Assert.assertArrayEquals(result, arrayTestSortOne);
    }

    @Test(timeout = 100)
    public void testInsertionSortTwo() {
        int[] result = InsertionSort.insertionSort(arrayTestTwo);
        Assert.assertArrayEquals(result, arrayTestSortTwo);
    }
}
```
- Kotlin:
``` Kotlin
class InsertionSortTest {
    private val arrayTestOne = intArrayOf(123, -10, 0, 1, -5, 1000, 321, 2, 0, 11)
    private val arrayTestSortOne = intArrayOf(-10, -5, 0, 0, 1, 2, 11, 123, 321, 1000)
    private val arrayTestTwo = intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3, -4, -5)
    private val arrayTestSortTwo = intArrayOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    @Test(timeout = 100)
    fun testInsertionSortOne() {
        val result = InsertionSort.insertionSort(arrayTestOne)
        Assert.assertArrayEquals(result, arrayTestSortOne)
    }

    @Test(timeout = 100)
    fun testInsertionSortTwo() {
        val result = InsertionSort.insertionSort(arrayTestTwo)
        Assert.assertArrayEquals(result, arrayTestSortTwo)
    }
}
```