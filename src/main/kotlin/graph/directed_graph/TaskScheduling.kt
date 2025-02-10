package graph.directed_graph

class TaskScheduling {
    fun taskScheduling(tasks: List<String>, requirements: List<List<String>>): List<String>? {
        val graph: HashMap<String, MutableList<String>> = HashMap()
        for (task in tasks) {
            graph[task] = arrayListOf()
        }
        for (req in requirements) {
            graph[req[0]]?.add(req[1])
        }
        return topoSort(graph)
    }

    private fun <T> topoSort(graph: java.util.HashMap<T, MutableList<T>>): List<T>? {
        val result: MutableList<T> = mutableListOf()
        val queue: ArrayDeque<T> = ArrayDeque()
        val inDegree: MutableMap<T, Int> = findInDegree(graph)
        inDegree.entries.forEach { entry ->
            if (entry.value == 0) {
                queue.add(entry.key)
            }
        }

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            result.add(node)
            for (neighbor in graph[node]!!) {
                inDegree[neighbor] = inDegree[neighbor]?.minus(1) ?: 0
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }
        return if (graph.size == result.size) result else null
    }

    private fun <T> findInDegree(graph: java.util.HashMap<T, MutableList<T>>): MutableMap<T, Int> {
        val inDegree = HashMap<T, Int>()
        graph.keys.forEach { node ->
            inDegree[node] = 0
        }

        graph.entries.forEach { entry ->
            for (node in entry.value) {
                inDegree[node] = inDegree[node]?.plus(1) ?: 0
            }
        }
        return inDegree
    }
}

fun main() {
    val obj = TaskScheduling()
//    val res = obj.taskScheduling(listOf("a", "b", "c", "d"), listOf(listOf("a", "b"), listOf("c", "b"), listOf("b", "d")))

    val res = obj.taskScheduling(listOf("0", "1", "2", "3"), listOf(listOf("0", "1"), listOf("0", "2"), listOf("1", "3"), listOf("2","3")))

    println(res?.joinToString())
}