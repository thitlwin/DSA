package graph.directed_graph

import kotlin.math.max

class TaskScheduling_2_withTime {
    fun minimumTime(n: Int, relations: Array<IntArray>, time: IntArray): Int {
        val graph: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
        val taskTimes: MutableMap<Int, Int> = mutableMapOf()

        for (i in 0 until n) {
            graph[i + 1] = mutableSetOf()
            taskTimes[i + 1] = time[i]
        }
        relations.forEach {
            graph[it[0]]?.add(it[1])
        }
        return topoSort(graph, taskTimes)
    }

    private fun topoSort(graph: MutableMap<Int, MutableSet<Int>>, taskTimes: MutableMap<Int, Int>): Int {
        var result = 0
        val queue: ArrayDeque<Int> = ArrayDeque()
        val distance: MutableMap<Int, Int> = HashMap()
        graph.keys.forEach {
            distance[it] = 0
        }

        // loop through all nodes and add all nodes that have degree 0
        val inDegree: MutableMap<Int, Int> = findIndegree(graph)
        inDegree.keys.forEach { node ->
            if (inDegree[node] == 0) {
                queue.add(node)
                distance[node] = taskTimes[node] ?: 0
                result = max(result, distance[node]!!)
            }
        }

        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            for (neighbor in graph[node]!!) {
                // subtract degree
                inDegree[neighbor] = inDegree[neighbor]?.minus(1) ?: 0
                distance[neighbor] = max(distance[neighbor] ?: 0, (distance[node] ?: 0) + (taskTimes[neighbor] ?: 0))
                result = max(result, distance[neighbor] ?: 0)
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }

        return result
    }

    private fun findIndegree(graph: MutableMap<Int, MutableSet<Int>>): MutableMap<Int, Int> {
        val indegree: MutableMap<Int, Int> = mutableMapOf()
        graph.keys.forEach {
            indegree[it] = 0
        }
        graph.entries.forEach { entry ->
            entry.value.forEach { node ->
                indegree[node] = indegree[node]?.plus(1) ?: 0
            }
        }
        return indegree
    }
}

fun main() {
    val obj = TaskScheduling_2_withTime()
    val res = obj.minimumTime(3, arrayOf(intArrayOf(1, 3), intArrayOf(2, 3)), intArrayOf(3, 2, 5))
    println(res)
}