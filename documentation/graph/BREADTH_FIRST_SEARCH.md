# [Алгоритмы](../../)

## Алгоритм обхода дерева графа в ширину

### Применимость:

- проверить наличия пути из А в Б
- является ли неориентированный граф связным
- найти кратчайший путь до узла удовлетворяющего условию (в невзвешенном графе)

### Вычислительная сложность:

`О(V + E)`, где `V` - количество вершин, `E` - количество рёбер

### Пример: вычисление суммы вершин графа

- Java:

Вспомогательная структура данных - Очередь

Абстракция:
``` Java
public interface Queue<D> {
    void offer(D data); // add data in end queue
    D poll(); // reed and delete data in start queue
    D peek(); // reed data in start queue
    boolean isEmpty();
}
```
Реализация:
``` Java
public class QueueImpl<D> implements Queue<D> {

    private LinkedList<D> list = new LinkedList<>();

    @Override
    public void offer(D data) {
        list.addLast(data);
    }

    @Override
    public D poll() {
        return list.removeFirst();
    }

    @Override
    public D peek() {
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
```
Сущность:
``` Java
public class GraphTree {
    private int vertex;
    private GraphTree left;
    private GraphTree right;

    // intermediate element
    public GraphTree(int vertex, GraphTree left, GraphTree right) {
        this.vertex = vertex;
        this.left = left;
        this.right = right;
    }

    // leaf
    public GraphTree(int vertex) {
        this.vertex = vertex;
    }

    public int getVertex() {
        return vertex;
    }

    public GraphTree getLeft() {
        return left;
    }

    public GraphTree getRight() {
        return right;
    }
}
```

Алгоритм:

``` Java
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
```

- Kotlin:
  Вспомогательная структура данных - Очередь

Абстракция:
``` Kotlin
interface Queue<D> {
    fun offer(data: D) // add data in end queue
    fun poll(): D // reed and delete data in start queue
    fun peek(): D // reed data in start queue
    val isEmpty: Boolean
}
```
Реализация:
``` Kotlin
class QueueImpl<D> : Queue<D> {
    private val list = LinkedList<D>()

    override fun offer(data: D) {
        list.addLast(data)
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
```
Сущность:
``` Kotlin
data class GraphTree(
    var vertex: Int = 0,
    val left: GraphTree? = null,
    val right: GraphTree? = null
)
```

Алгоритм:

``` Kotlin
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
```
### Примеры тестов:

- Java:
``` Java
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

    // BreadthFirstSearchTest
    @Test(timeout = 100)
    public void testBreadthIterativelySumGraph() {
        int result = BreadthFirstSearch.iterativelySumGraph(tree);
        Assert.assertEquals(result, sumGraphTree);
    }
}
```
- Kotlin:
``` Kotlin
class GraphAlgorithmsTest {
    private val tree: GraphTree = GraphTree(3,
        GraphTree(5,
            GraphTree(13,
                GraphTree(89), 
                GraphTree(144, 
                    GraphTree(4181),
                    GraphTree(6765,
                        GraphTree(10946),
                        GraphTree(17711)))),
            GraphTree(21, 
                GraphTree(233),
                GraphTree(377))),
        GraphTree(8,
            GraphTree(34,
                GraphTree(610),
                GraphTree(987)),
            GraphTree(55,
                GraphTree(1597),
                GraphTree(2584))))
    private val sumGraphTree = 46363

    // BreadthFirstSearchTest
    @Test(timeout = 100)
    fun testBreadthIterativelySumGraph() {
        val result = BreadthFirstSearch.iterativelySumGraph(tree)
        Assert.assertEquals(result.toLong(), sumGraphTree.toLong())
    }
}
```