package com.msaggik.algorithmsdatastructures.java.graph_tree;

import com.msaggik.algorithmsdatastructures.java.graph.graph_tree.BreadthFirstSearch;
import com.msaggik.algorithmsdatastructures.java.graph.graph_tree.DepthFirstSearch;
import com.msaggik.algorithmsdatastructures.java.graph.graph_tree.entity.GraphTree;

import org.junit.Assert;
import org.junit.Test;

public class GraphAlgorithmsTest {
    private final GraphTree tree
            = new GraphTree(3,
            new GraphTree(5,
                    new GraphTree(13,
                            new GraphTree(89),
                            new GraphTree(144,
                                    new GraphTree(4_181),
                                    new GraphTree(6_765,
                                            new GraphTree(10_946),
                                            new GraphTree(17_711)))),
                    new GraphTree(21,
                            new GraphTree(233),
                            new GraphTree(377))),
            new GraphTree(8,
                    new GraphTree(34,
                            new GraphTree(610),
                            new GraphTree(987)),
                    new GraphTree(55,
                            new GraphTree(1_597),
                            new GraphTree(2_584))));
    private final int sumGraphTree = 46_363;

    // DepthFirstSearchTest
    @Test(timeout = 100)
    public void testDepthRecursivelySumGraph() {
        int result = DepthFirstSearch.recursivelySumGraph(tree);
        Assert.assertEquals(result, sumGraphTree);
    }

    @Test(timeout = 100)
    public void testDepthIterativelySumGraph() {
        int result = DepthFirstSearch.iterativelySumGraph(tree);
        Assert.assertEquals(result, sumGraphTree);
    }

    // BreadthFirstSearchTest
    @Test(timeout = 100)
    public void testBreadthIterativelySumGraph() {
        int result = BreadthFirstSearch.iterativelySumGraph(tree);
        Assert.assertEquals(result, sumGraphTree);
    }
}
