package com.msaggik.algorithmsdatastructures.kotlin.graph_tree

import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.BreadthFirstSearch
import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.DepthFirstSearch
import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_tree.entity.GraphTree
import org.junit.Assert
import org.junit.Test

class GraphAlgorithmsTest {
    private val tree: GraphTree = GraphTree(3,
        GraphTree(5,
            GraphTree(13,
                GraphTree(89),
                GraphTree(144,
                    GraphTree(4181),
                    GraphTree(6765,
                        GraphTree(10946),
                        GraphTree(17711)
                    )
                )
            ),
            GraphTree(21,
                GraphTree(233),
                GraphTree(377)
            )
        ),
        GraphTree(8,
            GraphTree(34,
                GraphTree(610),
                GraphTree(987)
            ),
            GraphTree(55,
                GraphTree(1597),
                GraphTree(2584)
            )
        )
    )
    private val sumGraphTree = 46363

    // DepthFirstSearchTest
    @Test(timeout = 100)
    fun testDepthRecursivelySumGraph() {
        val result = DepthFirstSearch.recursivelySumGraph(tree)
        Assert.assertEquals(result.toLong(), sumGraphTree.toLong())
    }

    @Test(timeout = 100)
    fun testDepthIterativelySumGraph() {
        val result = DepthFirstSearch.iterativelySumGraph(tree)
        Assert.assertEquals(result.toLong(), sumGraphTree.toLong())
    }

    // BreadthFirstSearchTest
    @Test(timeout = 100)
    fun testBreadthIterativelySumGraph() {
        val result = BreadthFirstSearch.iterativelySumGraph(tree)
        Assert.assertEquals(result.toLong(), sumGraphTree.toLong())
    }
}
