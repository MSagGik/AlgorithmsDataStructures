package com.msaggik.algorithmsdatastructures.java.ai;

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
