package com.msaggik.algorithmsdatastructures.java.graph.graph_weighted;

import com.msaggik.algorithmsdatastructures.java.graph.graph_weighted.entity.Road;
import com.msaggik.algorithmsdatastructures.java.graph.graph_weighted.entity.Vertex;

import java.util.PriorityQueue;

/**
 * Алгоритм Дейкстры
 * Упрощённая модель:  V - количество вершин, E - количество рёбер
 * применим к задачам:
 * - нахождение минимального расстояния между вершинами в взвешенном графе
 *
 * Вычислительная сложность: О(V^2 + E)
 **/

public class DijkstrasAlgorithm {

    public static void calculateDistance(Vertex startVertex) {
        startVertex.setDistance(0);
        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        queue.add(startVertex); // добавление стартовой вершины в очередь

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll(); // извлечение вершины из очереди

            assert vertex != null;
            for (Road road: vertex.getRoads()) { // просмотр у неё всех дорог
                Vertex endVertex = road.getEndVertex(); // берётся одна из связующих вершин
                if (!endVertex.isVisited()) { // если данную вершину ещё не посещали

                    int distanceSum = vertex.getDistance() + road.getWeightRoad(); // берётся дистанция исходной точки и вес дороги

                    if (distanceSum < endVertex.getDistance()) { // если она меньше дистанции целевой точки (по умолчанию в ней она бесконечность)
                        endVertex.setDistance(distanceSum); // то устанавливаем в конечной точке данную дистанцию
                        queue.add(endVertex); // и добавляем конечную вершину в конец очереди
                        endVertex.setPredecessor(vertex); // ещё добавляем информацию о предыдущей вершине к конечной
                    }
                }
            }
            vertex.setVisited(true); // отмечаем что исходную вершину посетили
        }
    }

    public static void track(Vertex endVertex) {
        Vertex endPoint = endVertex;
        while (endPoint != null) {
            System.out.print(endPoint.getTitle() + " distance " + endPoint.getDistance() + ", ");
            endPoint = endPoint.getPredecessor();
        }
        System.out.print("\n");
    }
}
