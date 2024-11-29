package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree

import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.data_structures.Queue
import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.data_structures.QueueImpl
import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.entity.GraphTree

object BreadthFirstSearch {
    fun iterativelySumGraph(tree: GraphTree): Int {
        val queue: Queue<GraphTree> = QueueImpl()
        queue.offer(tree)

        var sumGraph = 0

        while (!queue.isEmpty) {
            val treeBuf = checkNotNull(queue.poll())

            sumGraph += treeBuf.vertex

            if (treeBuf.right != null) {
                queue.offer(treeBuf.right)
            }

            if (treeBuf.left != null) {
                queue.offer(treeBuf.left)
            }
        }
        return sumGraph
    }
}