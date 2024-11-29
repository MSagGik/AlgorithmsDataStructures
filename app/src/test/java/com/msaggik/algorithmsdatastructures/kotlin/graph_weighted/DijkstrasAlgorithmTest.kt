package com.msaggik.algorithmsdatastructures.kotlin.graph_weighted

import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted.DijkstrasAlgorithm
import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted.entity.Road
import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted.entity.Vertex
import org.junit.Assert
import org.junit.Test

class DijkstrasAlgorithmTest {
    private val v1: Vertex = Vertex("v1")
    private val v2: Vertex = Vertex("v2")
    private val v3: Vertex = Vertex("v3")
    private val v4: Vertex = Vertex("v4")
    private val v5: Vertex = Vertex("v5")
    private val v6: Vertex = Vertex("v6")
    private val v7: Vertex = Vertex("v7")

    private val r1To2 = Road(v1, v2, 1)
    private val r2To3 = Road(v2, v3, 3)
    private val r2To6 = Road(v2, v6, 50)
    private val r3To4 = Road(v3, v4, 10)
    private val r3To5 = Road(v3, v5, 5)
    private val r4To5 = Road(v4, v5, 9)
    private val r5To6 = Road(v5, v6, 6)
    private val r6To7 = Road(v6, v7, 1)
    private val r6To2 = Road(v6, v2, 3)

    private fun addRoadsToVertex() {
        v1.addRoad(r1To2)
        v2.addRoad(r2To3)
        v2.addRoad(r2To6)
        v3.addRoad(r3To4)
        v3.addRoad(r3To5)
        v4.addRoad(r4To5)
        v5.addRoad(r5To6)
        v6.addRoad(r6To7)
        v6.addRoad(r6To2)
    }

    @Test(timeout = 100)
    fun testDijkstrasAlgorithm() {
        addRoadsToVertex()
        DijkstrasAlgorithm.calculateDistance(v1)
        val result: Int = v7.distance
        DijkstrasAlgorithm.track(v7)
        Assert.assertEquals(result.toLong(), 16)
    }
}