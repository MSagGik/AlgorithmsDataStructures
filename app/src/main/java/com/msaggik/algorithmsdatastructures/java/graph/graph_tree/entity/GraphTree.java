package com.msaggik.algorithmsdatastructures.java.graph.graph_tree.entity;

public class GraphTree {
    private int vertex;
    private GraphTree left;
    private GraphTree right;

    // intermediate element
    public GraphTree(int vertex, GraphTree left, GraphTree right) {
        this.vertex = vertex;
        this.left = left;
        this.right = right;
    }

    // leaf
    public GraphTree(int vertex) {
        this.vertex = vertex;
    }

    public int getVertex() {
        return vertex;
    }

    public GraphTree getLeft() {
        return left;
    }

    public GraphTree getRight() {
        return right;
    }
}
