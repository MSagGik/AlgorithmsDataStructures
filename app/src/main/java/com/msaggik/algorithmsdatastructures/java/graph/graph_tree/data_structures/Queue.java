package com.msaggik.algorithmsdatastructures.java.graph.graph_tree.data_structures;

public interface Queue<D> {
    void offer(D data); // add data in end queue
    D poll(); // reed and delete data in start queue
    D peek(); // reed data in start queue
    boolean isEmpty();
}
