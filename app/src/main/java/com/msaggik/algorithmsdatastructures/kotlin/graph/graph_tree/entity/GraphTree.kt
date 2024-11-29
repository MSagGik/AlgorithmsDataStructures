package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.entity

data class GraphTree(
    var vertex: Int = 0,
    val left: GraphTree? = null,
    val right: GraphTree? = null
)
