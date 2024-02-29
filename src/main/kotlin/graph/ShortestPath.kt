package graph

class ShortestPath {
    fun shortestPath(graph: List<List<Int>>, start: Int, end: Int): Int {
        val queue = ArrayDeque<Int>()
        queue.add(start)
        val visited = HashSet<Int>()
        visited.add(start)
        var level = 0
        while (queue.size > 0) {
            val n = queue.size
            for (i in 0 until n) {
                val node = queue.removeFirst()
                if (node == end) return level
                for (neighbour in getNeighbors(graph, node)) {
                    if (visited.contains(neighbour)) continue
                    queue.add(neighbour)
                    visited.add(neighbour)
                }
            }
            level++
        }
        return level
    }

    private fun getNeighbors(graph: List<List<Int>>, node: Int): List<Int> {
        return graph[node]
    }
}

fun main() {
    val obj = ShortestPath()
    val graph = listOf(listOf(1,2), listOf(0,2,3), listOf(0,1), listOf(1))
    println(obj.shortestPath(graph,0, 3))
}