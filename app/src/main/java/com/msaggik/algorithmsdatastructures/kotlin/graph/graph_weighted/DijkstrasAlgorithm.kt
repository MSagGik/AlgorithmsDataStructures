package com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted

import com.msaggik.algorithmsdatastructures.kotlin.graph.graph_weighted.entity.Vertex
import java.util.PriorityQueue

object  DijkstrasAlgorithm {

    fun calculateDistance(startVertex: Vertex) {
        startVertex.distance = 0
        val queue = PriorityQueue<Vertex>()
        queue.add(startVertex) // добавление стартовой вершины в очередь

        while (!queue.isEmpty()) {
            val vertex: Vertex = checkNotNull(queue.poll()) // извлечение вершины из очереди

            for (road in vertex.roads) { // просмотр у неё всех дорог
                val endVertex = road.endVertex// берётся одна из связующих вершин
                if (!endVertex.visited) { // если данную вершину ещё не посещали

                        val distanceSum = vertex.distance + road.weightRoad // берётся дистанция исходной точки и вес дороги

                        if (distanceSum < endVertex.distance) { // если она меньше дистанции целевой точки (по умолчанию в ней она бесконечность)
                            endVertex.distance = distanceSum // то устанавливаем в конечной точке данную дистанцию
                            queue.add(endVertex) // и добавляем конечную вершину в конец очереди
                            endVertex.predecessor = vertex // ещё добавляем информацию о предыдущей вершине к конечной
                        }
                    }
            }
            vertex.visited = true // отмечаем что исходную вершину посетили
        }
    }

    fun track(endVertex: Vertex?) {
        var endPoint = endVertex
        while (endPoint != null) {
            print(endPoint.title + " distance " + endPoint.distance + ", ")
            endPoint = endPoint.predecessor
        }
        print("\n")
    }
}
