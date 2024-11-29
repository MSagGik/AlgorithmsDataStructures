package com.msaggik.algorithmsdatastructures.java.graph.graph_weighted.entity;

public class Road {
    private Vertex startVertex, endVertex;
    private int weightRoad;

    public Road(Vertex startVertex, Vertex endVertex, int weightRoad) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weightRoad = weightRoad;
    }

    // getters and setters
    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public int getWeightRoad() {
        return weightRoad;
    }

    public void setWeightRoad(int weightRoad) {
        this.weightRoad = weightRoad;
    }
}
