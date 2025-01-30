package graph.shortest_path

class ShortestPath2 {
    fun shortestPath(graph: List<List<Int>>, start: Int, end: Int): Int {
        val queue: ArrayDeque<Int> = ArrayDeque()
        val visited: MutableSet<Int> = mutableSetOf()
        var level = 0
        queue.add(start)
        visited.add(start)
        while (queue.isNotEmpty()) {
            val qSize = queue.size
            for (i in 0 until qSize) {
                val node = queue.removeFirst()
                if (node == end) {
                    return level
                }
                for (n in neighbors(graph, node)) {
                    if (!visited.contains(n)) {
                        visited.add(n)
                        queue.add(n)
                    }
                }
            }
            level++
        }
        return level
    }

    private fun neighbors(graph: List<List<Int>>, node: Int): List<Int> {
        return graph[node]
    }
}

fun main() {
    val obj = ShortestPath2()
    val graph = listOf(listOf(1,2), listOf(0,2,3), listOf(0,1), listOf(1))
    val res = obj.shortestPath(graph,0, 3)
    println(res)
}