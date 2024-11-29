# [Алгоритмы](../../)

## Многослойный перцептрон

### Применимость:

- классификация
- распознавание образов

### Вычислительная сложность:

`O(n * m * p)`, где `n` — количество обучающих примеров, `m` — количество нейронов в скрытых слоях, `p` — количество итераций

### Пример

- Java:
``` Java
public class MultiLayerPerceptron {
    private int inputSize;
    private int hiddenSize;
    private int outputSize;
    public double[][] weightsInputHidden;
    public double[][] weightsHiddenOutput;
    private double learningRate;

    public MultiLayerPerceptron(int inputSize, int hiddenSize, int outputSize, double learningRate) {
        this.inputSize = inputSize;
        this.hiddenSize = hiddenSize;
        this.outputSize = outputSize;
        this.learningRate = learningRate;
        this.weightsInputHidden = new double[inputSize][hiddenSize];
        this.weightsHiddenOutput = new double[hiddenSize][outputSize];

        // Инициализация весов случайными значениями
        initializeWeights(weightsInputHidden);
        initializeWeights(weightsHiddenOutput);
    }

    private void initializeWeights(double[][] weights) {
        for (int i = 0; i < weights.length; i++) {
            for (int j = 0; j < weights[i].length; j++) {
                weights[i][j] = Math.random() - 0.5; // случайные значения от -0.5 до 0.5
            }
        }
    }

    public double[] predict(double[] input) {
        double[] hiddenLayer = new double[hiddenSize];
        double[] outputLayer = new double[outputSize];

        // Прямое распространение
        for (int j = 0; j < hiddenSize; j++) {
            hiddenLayer[j] = sigmoid(dotProduct(input, getColumn(weightsInputHidden, j)));
        }

        for (int k = 0; k < outputSize; k++) {
            outputLayer[k] = sigmoid(dotProduct(hiddenLayer, getColumn(weightsHiddenOutput, k)));
        }

        return outputLayer;
    }

    private double dotProduct(double[] input, double[] weights) {
        double sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i] * weights[i];
        }
        return sum;
    }

    private double sigmoid(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    private double[] getColumn(double[][] matrix, int columnIndex) {
        double[] column = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            column[i] = matrix[i][columnIndex];
        }
        return column;
    }
}
```

- Kotlin:

``` Kotlin
class MultiLayerPerceptron(
    private val inputSize: Int,
    private val hiddenSize: Int,
    private val outputSize: Int,
    private val learningRate: Double
) {
    val weightsInputHidden = Array(inputSize) { DoubleArray(hiddenSize) }
    val weightsHiddenOutput = Array(hiddenSize) { DoubleArray(outputSize) }

    init {
        initializeWeights(weightsInputHidden)
        initializeWeights(weightsHiddenOutput)
    }

    private fun initializeWeights(weights: Array<DoubleArray>) {
        for (i in weights.indices) {
            for (j in weights[i].indices) {
                weights[i][j] = Random.nextDouble(-0.5, 0.5) // случайные значения от -0.5 до 0.5
            }
        }
    }

    fun predict(input: DoubleArray): DoubleArray {
        val hiddenLayer = DoubleArray(hiddenSize)
        val outputLayer = DoubleArray(outputSize)

        // Прямое распространение
        for (j in hiddenLayer.indices) {
            hiddenLayer[j] = sigmoid(dotProduct(input, getColumn(weightsInputHidden, j)))
        }

        for (k in outputLayer.indices) {
            outputLayer[k] = sigmoid(dotProduct(hiddenLayer, getColumn(weightsHiddenOutput, k)))
        }

        return outputLayer
    }

    private fun dotProduct(input: DoubleArray, weights: DoubleArray): Double {
        return input.indices.sumOf { input[it] * weights[it] }
    }

    private fun sigmoid(x: Double): Double {
        return 1 / (1 + exp(-x))
    }

    private fun getColumn(matrix: Array<DoubleArray>, columnIndex: Int): DoubleArray {
        return DoubleArray(matrix.size) { matrix[it][columnIndex] }
    }
}
```
### Примеры тестов:

- Java:
``` Java
public class MultiLayerPerceptronTest {

    @Test
    public void testPredict() {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron(2, 3, 1, 0.1);
        double[] input = {0.5, 0.2};
        double[] output = mlp.predict(input);

        // Проверяем, что выход имеет правильный размер
        assertEquals(1, output.length);

        // Проверяем, что выход находится в диапазоне [0, 1]
        assertTrue(output[0] >= 0 && output[0] <= 1);
    }

    @Test
    public void testWeightsInitialization() {
        MultiLayerPerceptron mlp = new MultiLayerPerceptron(2, 3, 1, 0.1);

        // Проверяем, что веса не равны нулю
        for (double[] weights : mlp.weightsInputHidden) {
            for (double weight : weights) {
                assertNotEquals(0, weight, 0.01);
            }
        }

        for (double[] weights : mlp.weightsHiddenOutput) {
            for (double weight : weights) {
                assertNotEquals(0, weight, 0.01);
            }
        }
    }
}
```
- Kotlin:
``` Kotlin
class MultiLayerPerceptronTest {

    @Test
    fun testPredict() {
        val mlp = MultiLayerPerceptron(2, 3, 1, 0.1)
        val input = doubleArrayOf(0.5, 0.2)
        val output = mlp.predict(input)

        // Проверяем, что выход имеет правильный размер
        assertEquals(1, output.size)

        // Проверяем, что выход находится в диапазоне [0, 1]
        assertTrue(output[0] in 0.0..1.0)
    }

    @Test
    fun testWeightsInitialization() {
        val mlp = MultiLayerPerceptron(2, 3, 1, 0.1)

        // Проверяем, что веса не равны нулю
        for (weights in mlp.weightsInputHidden) {
            for (weight in weights) {
                assertNotEquals(0.0, weight, 0.01)
            }
        }

        for (weights in mlp.weightsHiddenOutput) {
            for (weight in weights) {
                assertNotEquals(0.0, weight, 0.01)
            }
        }
    }
}
```