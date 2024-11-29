package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree

import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.entity.GraphTree
import java.util.Stack

object DepthFirstSearch {
    fun recursivelySumGraph(tree: GraphTree): Int {
        var sumGraph: Int = tree.vertex

        if (tree.left != null) {
            sumGraph += recursivelySumGraph(tree.left)
        }
        if (tree.right != null) {
            sumGraph += recursivelySumGraph(tree.right)
        }
        return sumGraph
    }

    fun iterativelySumGraph(tree: GraphTree): Int {
        val stack: Stack<GraphTree> = Stack<GraphTree>()
        stack.push(tree)

        var sumGraph = 0

        while (!stack.isEmpty()) {
            val treeBuf: GraphTree = stack.pop()

            sumGraph += treeBuf.vertex

            if (treeBuf.right != null) {
                stack.push(treeBuf.right)
            }

            if (treeBuf.left != null) {
                stack.push(treeBuf.left)
            }
        }
        return sumGraph
    }
}
