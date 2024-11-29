package com.msaggik.algorithmsdatastructures.java.graph.graph_weighted.entity;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex>{
    private String title;
    private boolean visited;
    private List<Road> roads = new ArrayList<>();

    private int distance = Integer.MAX_VALUE;
    private Vertex predecessor = null;

    public Vertex(String title) {
        this.title = title;
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    // getters and setters
    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    @Override
    public int compareTo(Vertex vertex) {
        return Integer.compare(this.getDistance(), vertex.getDistance());
    }
}
