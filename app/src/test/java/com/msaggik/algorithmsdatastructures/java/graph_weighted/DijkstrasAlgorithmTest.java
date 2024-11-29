package com.msaggik.algorithmsdatastructures.java.graph_weighted;

import com.msaggik.algorithmsdatastructures.java.graph.graph_weighted.DijkstrasAlgorithm;
import com.msaggik.algorithmsdatastructures.java.graph.graph_weighted.entity.Road;
import com.msaggik.algorithmsdatastructures.java.graph.graph_weighted.entity.Vertex;

import org.junit.Assert;
import org.junit.Test;

public class DijkstrasAlgorithmTest {
    private final Vertex v1 = new Vertex("v1");
    private final Vertex v2 = new Vertex("v2");
    private final Vertex v3 = new Vertex("v3");
    private final Vertex v4 = new Vertex("v4");
    private final Vertex v5 = new Vertex("v5");
    private final Vertex v6 = new Vertex("v6");
    private final Vertex v7 = new Vertex("v7");

    private final Road r1To2 = new Road(v1, v2, 1);
    private final Road r2To3 = new Road(v2, v3, 3);
    private final Road r2To6 = new Road(v2, v6, 50);
    private final Road r3To4 = new Road(v3, v4, 10);
    private final Road r3To5 = new Road(v3, v5, 5);
    private final Road r4To5 = new Road(v4, v5, 9);
    private final Road r5To6 = new Road(v5, v6, 6);
    private final Road r6To7 = new Road(v6, v7, 1);
    private final Road r6To2 = new Road(v6, v2, 3);

    private void addRoadsToVertex() {
        v1.addRoad(r1To2);
        v2.addRoad(r2To3);
        v2.addRoad(r2To6);
        v3.addRoad(r3To4);
        v3.addRoad(r3To5);
        v4.addRoad(r4To5);
        v5.addRoad(r5To6);
        v6.addRoad(r6To7);
        v6.addRoad(r6To2);
    }

    @Test(timeout = 100)
    public void testDijkstrasAlgorithm() {
        addRoadsToVertex();
        DijkstrasAlgorithm.calculateDistance(v1);
        int result = v7.getDistance();
        DijkstrasAlgorithm.track(v7);
        Assert.assertEquals(result, 16);
    }
}

