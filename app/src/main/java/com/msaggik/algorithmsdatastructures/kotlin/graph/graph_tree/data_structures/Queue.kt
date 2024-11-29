package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.data_structures

interface Queue<D> {
    fun offer(data: D) // add data in end queue
    fun poll(): D // reed and delete data in start queue
    fun peek(): D // reed data in start queue
    val isEmpty: Boolean
}