# [Алгоритмы](../../)

## Бинарный поиск

### Применимость:

Для отсортированной последовательности чисел

### Вычислительная сложность:

`O(log(N))`

### Пример: поиск наличия числа value в массиве

- Java:

``` Java
public class BinarySearch {
    static int isValueInArray(int[] arrayInt, int value) {
        int left = 0, right = arrayInt.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int current = arrayInt[middle];
            if (current == value) return middle;
            else if (current < value) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
```
- Kotlin:
``` Kotlin
object BinarySearch {
    fun isValueInArray(arrayInt: IntArray, value: Int): Int {
        var left = 0
        var right = arrayInt.size - 1
        while (left <= right) {
            val middle = (left + right) / 2
            val current = arrayInt[middle]
            if (current == value) return middle
            else if (current < value) left = middle + 1
            else right = middle - 1
        }
        return -1
    }
}
```
### Примеры тестов:

- Java:
``` Java
public class BinarySearchTest {
    private final int[] arrayTestOne = {2, 10, 21, 123, 888, 3221, 1000};
    private final int[] arrayTestTwo = {-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 10000};

    @Test(timeout = 100)
    public void testBinarySearchOneTrue() {
        int result = BinarySearch.isValueInArray(arrayTestOne, 21);
        Assert.assertEquals(result, 2);
    }

    @Test(timeout = 100)
    public void testBinarySearchOneFalse() {
        int result = BinarySearch.isValueInArray(arrayTestOne, 100);
        Assert.assertEquals(result, -1);
    }

    @Test(timeout = 100)
    public void testBinarySearchTwoTrue() {
        int result = BinarySearch.isValueInArray(arrayTestTwo, 21);
        Assert.assertEquals(result, 6);
    }

    @Test(timeout = 100)
    public void testBinarySearchFalse() {
        int result = BinarySearch.isValueInArray(arrayTestTwo, 100);
        Assert.assertEquals(result, -1);
    }
}
```
- Kotlin:
``` Kotlin
class BinarySearchTest {
    private val arrayTestOne = intArrayOf(2, 10, 21, 123, 888, 3221, 1000)
    private val arrayTestTwo = intArrayOf(-123, -17, -3, 0, 2, 10, 21, 123, 888, 3221, 10000)

    @Test(timeout = 100)
    fun testBinarySearchOneTrue() {
        val result = BinarySearch.isValueInArray(arrayTestOne, 21)
        Assert.assertEquals(result.toLong(), 2)
    }

    @Test(timeout = 100)
    fun testBinarySearchOneFalse() {
        val result = BinarySearch.isValueInArray(arrayTestOne, 100)
        Assert.assertEquals(result.toLong(), -1)
    }

    @Test(timeout = 100)
    fun testBinarySearchTwoTrue() {
        val result = BinarySearch.isValueInArray(arrayTestTwo, 21)
        Assert.assertEquals(result.toLong(), 6)
    }

    @Test(timeout = 100)
    fun testBinarySearchFalse() {
        val result = BinarySearch.isValueInArray(arrayTestTwo, 100)
        Assert.assertEquals(result.toLong(), -1)
    }
}
```