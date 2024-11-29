package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted.entity

data class Vertex(
    var title: String? = null
) : Comparable<Vertex> {
    var visited: Boolean = false
    var roads: MutableList<Road> = ArrayList<Road>()
    var distance: Int = Int.MAX_VALUE
    var predecessor: Vertex? = null

    fun addRoad(road: Road) {
        roads.add(road)
    }

    override fun compareTo(other: Vertex): Int {
        return distance.compareTo(other.distance)
    }
}
