package com.msaggik.algorithmsdatastructures.kotlin.ai

import kotlin.math.exp
import kotlin.random.Random

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