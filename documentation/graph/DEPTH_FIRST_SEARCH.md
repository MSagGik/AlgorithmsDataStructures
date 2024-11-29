# [Алгоритмы](../../)

## Алгоритм обхода дерева графа в глубину

### Применимость:

- проверить наличия пути из А в Б
- является ли неориентированный граф связным

### Вычислительная сложность:

`О(V + E)`, где `V` - количество вершин, `E` - количество рёбер

Рекурсивный алгоритм хуже и медленей, так как требует использование основного стека памяти,
поэтому лучше использовать итерактивный подход

### Пример: вычисление суммы вершин графа

- Java:

Вспомогательная структура данных - Стек (java.util.Stack)

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

Алгоритмы:

``` Java
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
```

- Kotlin:
  
Вспомогательная структура данных - Стек (java.util.Stack)

Сущность:
``` Kotlin
data class GraphTree(
    var vertex: Int = 0,
    val left: GraphTree? = null,
    val right: GraphTree? = null
)
```

Алгоритмы:

``` Kotlin
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
}
```