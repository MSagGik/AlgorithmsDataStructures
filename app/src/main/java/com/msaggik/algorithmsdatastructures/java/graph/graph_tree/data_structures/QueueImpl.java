package com.msaggik.algorithmsdatastructures.java.graph.graph_tree.data_structures;

import java.util.LinkedList;

public class QueueImpl<D> implements Queue<D> {

    private LinkedList<D> list = new LinkedList<>();

    @Override
    public void offer(D data) {
        list.addLast(data);
    }

    @Override
    public D poll() {
        return list.removeFirst();
    }

    @Override
    public D peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
