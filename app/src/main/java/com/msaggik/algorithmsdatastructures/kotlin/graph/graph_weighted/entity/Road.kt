package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted.entity

import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted.entity.Vertex

data class Road(
    var startVertex: Vertex,
    var endVertex: Vertex,
    var weightRoad: Int = 0
)
