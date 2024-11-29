package com.msaggik.algorithmsdatastructures.java.graph.graph_tree;

import com.msaggik.algorithmsdatastructures.java.graph.graph_tree.entity.GraphTree;

import java.util.Stack;

/**
 * Алгоритм обхода дерева графа в глубину
 * Упрощённая модель:  V - количество вершин, E - количество рёбер
 * применим к задачам:
 * - проверить наличия пути из А в Б
 * - является ли неориентированный граф связным
 * <p>
 * Вычислительная сложность: О(V + E)
 * <p>
 * Рекурсивный алгоритм хуже и медленей, так как требует использование основного стека памяти,
 * поэтому лучше использовать итерактивный подход
 **/

public class DepthFirstSearch {

    public static int recursivelySumGraph(GraphTree tree) {
        int sumGraph = tree.getVertex();

        if(tree.getLeft() != null) {
            sumGraph += recursivelySumGraph(tree.getLeft());
        }
        if(tree.getRight() != null) {
            sumGraph += recursivelySumGraph(tree.getRight());
        }
        return sumGraph;
    }

    public static int iterativelySumGraph(GraphTree tree) {
        Stack<GraphTree> stack = new Stack<>();
        stack.push(tree);

        int sumGraph = 0;

        while (!stack.isEmpty()) {
            GraphTree treeBuf = stack.pop();

            sumGraph += treeBuf.getVertex();

            if(treeBuf.getRight() != null) {
                stack.push(treeBuf.getRight());
            }

            if(treeBuf.getLeft() != null) {
                stack.push(treeBuf.getLeft());
            }
        }
        return sumGraph;
    }
}
