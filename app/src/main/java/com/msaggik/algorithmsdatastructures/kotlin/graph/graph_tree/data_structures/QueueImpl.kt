package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.data_structures

import java.util.LinkedList

class QueueImpl<D> : Queue<D> {
    private val list = LinkedList<D>()

    override fun offer(data: D) {
        list.add(data)
    }

    override fun poll(): D {
        return list.removeFirst()
    }

    override fun peek(): D {
        return list.first
    }

    override val isEmpty: Boolean
        get() = list.isEmpty()
}