package com.msaggik.algorithmsdatastructures.java.graph.graph_tree;

import com.msaggik.algorithmsdatastructures.java.graph.graph_tree.data_structures.Queue;
import com.msaggik.algorithmsdatastructures.java.graph.graph_tree.data_structures.QueueImpl;
import com.msaggik.algorithmsdatastructures.java.graph.graph_tree.entity.GraphTree;

/**
 * Алгоритм обхода дерева графа в ширину
 * Упрощённая модель:  V - количество вершин, E - количество рёбер
 * применим к задачам:
 * - проверить наличия пути из А в Б
 * - является ли неориентированный граф связным
 * - найти кратчайший путь до узла удовлетворяющего условию (в невзвешенном графе)
 *
 * Вычислительная сложность: О(V + E)
 **/

public class BreadthFirstSearch {
    public static int iterativelySumGraph(GraphTree tree) {
        Queue<GraphTree> queue = new QueueImpl<>();
        queue.offer(tree);

        int sumGraph = 0;

        while (!queue.isEmpty()) {
            GraphTree treeBuf = queue.poll();

            assert treeBuf != null;
            sumGraph += treeBuf.getVertex();

            if(treeBuf.getRight() != null) {
                queue.offer(treeBuf.getRight());
            }

            if(treeBuf.getLeft() != null) {
                queue.offer(treeBuf.getLeft());
            }
        }
        return sumGraph;
    }
}
