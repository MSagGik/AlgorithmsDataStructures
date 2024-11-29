# [Алгоритмы](../../)

## Алгоритм Дейкстры

### Применимость:

- нахождение минимального расстояния между вершинами в взвешенном графе

### Вычислительная сложность:

`О(V^2 + E)`, где `V` - количество вершин, `E` - количество рёбер

### Пример: вычисление кратчайших расстояний всех вершин к заданной вершине и их трасировка

- Java:

Сущности:
1) Вершина
``` Java
public class Vertex implements Comparable<Vertex>{
    private String title;
    private boolean visited;
    private List<Road> roads = new ArrayList<>();

    private int distance = Integer.MAX_VALUE;
    private Vertex predecessor = null;

    public Vertex(String title) {
        this.title = title;
    }

    public void addRoad(Road road) {
        roads.add(road);
    }

    // getters and setters
    public Vertex getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor) {
        this.predecessor = predecessor;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Road> getRoads() {
        return roads;
    }

    public void setRoads(List<Road> roads) {
        this.roads = roads;
    }

    @Override
    public int compareTo(Vertex vertex) {
        return Integer.compare(this.getDistance(), vertex.getDistance());
    }
}
```
2) Луч
``` Java
public class Road {
    private Vertex startVertex, endVertex;
    private int weightRoad;

    public Road(Vertex startVertex, Vertex endVertex, int weightRoad) {
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.weightRoad = weightRoad;
    }

    // getters and setters
    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getEndVertex() {
        return endVertex;
    }

    public void setEndVertex(Vertex endVertex) {
        this.endVertex = endVertex;
    }

    public int getWeightRoad() {
        return weightRoad;
    }

    public void setWeightRoad(int weightRoad) {
        this.weightRoad = weightRoad;
    }
}
```

Алгоритм:

``` Java
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
```

- Kotlin:

Сущности:
1) Вершина
``` Kotlin
data class Vertex(
    var title: String? = null
) : Comparable<Vertex> {
    var visited: Boolean = false
    var roads: MutableList<Road> = ArrayList<Road>()
    var distance: Int = Int.MAX_VALUE
    var predecessor: Vertex? = null

    fun addRoad(road: Road) {
        roads.add(road)
    }

    override fun compareTo(other: Vertex): Int {
        return distance.compareTo(other.distance)
    }
}
```

2) Луч
``` Kotlin
data class Road(
    var startVertex: Vertex,
    var endVertex: Vertex,
    var weightRoad: Int = 0
)
```

Алгоритм:

``` Kotlin
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
```
### Примеры тестов:

- Java:
``` Java
public class DijkstrasAlgorithmTest {
    private final Vertex v1 = new Vertex("v1");
    private final Vertex v2 = new Vertex("v2");
    private final Vertex v3 = new Vertex("v3");
    private final Vertex v4 = new Vertex("v4");
    private final Vertex v5 = new Vertex("v5");
    private final Vertex v6 = new Vertex("v6");
    private final Vertex v7 = new Vertex("v7");

    private final Road r1To2 = new Road(v1, v2, 1);
    private final Road r2To3 = new Road(v2, v3, 3);
    private final Road r2To6 = new Road(v2, v6, 50);
    private final Road r3To4 = new Road(v3, v4, 10);
    private final Road r3To5 = new Road(v3, v5, 5);
    private final Road r4To5 = new Road(v4, v5, 9);
    private final Road r5To6 = new Road(v5, v6, 6);
    private final Road r6To7 = new Road(v6, v7, 1);
    private final Road r6To2 = new Road(v6, v2, 3);

    private void addRoadsToVertex() {
        v1.addRoad(r1To2);
        v2.addRoad(r2To3);
        v2.addRoad(r2To6);
        v3.addRoad(r3To4);
        v3.addRoad(r3To5);
        v4.addRoad(r4To5);
        v5.addRoad(r5To6);
        v6.addRoad(r6To7);
        v6.addRoad(r6To2);
    }
    
    @Test(timeout = 100)
    public void testDijkstrasAlgorithm() {
        addRoadsToVertex();
        DijkstrasAlgorithm.calculateDistance(v1);
        int result = v7.getDistance();
        DijkstrasAlgorithm.track(v7);
        Assert.assertEquals(result, 16);
    }
}
```
- Kotlin:
``` Kotlin
class DijkstrasAlgorithmTest {
    private val v1: Vertex = Vertex("v1")
    private val v2: Vertex = Vertex("v2")
    private val v3: Vertex = Vertex("v3")
    private val v4: Vertex = Vertex("v4")
    private val v5: Vertex = Vertex("v5")
    private val v6: Vertex = Vertex("v6")
    private val v7: Vertex = Vertex("v7")

    private val r1To2 = Road(v1, v2, 1)
    private val r2To3 = Road(v2, v3, 3)
    private val r2To6 = Road(v2, v6, 50)
    private val r3To4 = Road(v3, v4, 10)
    private val r3To5 = Road(v3, v5, 5)
    private val r4To5 = Road(v4, v5, 9)
    private val r5To6 = Road(v5, v6, 6)
    private val r6To7 = Road(v6, v7, 1)
    private val r6To2 = Road(v6, v2, 3)

    private fun addRoadsToVertex() {
        v1.addRoad(r1To2)
        v2.addRoad(r2To3)
        v2.addRoad(r2To6)
        v3.addRoad(r3To4)
        v3.addRoad(r3To5)
        v4.addRoad(r4To5)
        v5.addRoad(r5To6)
        v6.addRoad(r6To7)
        v6.addRoad(r6To2)
    }

    @Test(timeout = 100)
    fun testDijkstrasAlgorithm() {
        addRoadsToVertex()
        DijkstrasAlgorithm.calculateDistance(v1)
        val result: Int = v7.distance
        DijkstrasAlgorithm.track(v7)
        Assert.assertEquals(result.toLong(), 16)
    }
}
```