package graph.directed_graph

import java.util.PriorityQueue
// TC for graph construction = O(T * L),
//Overall Time Complexity
//Combining graph construction and topological sorting:
//
//O(T * L + V + E)
//T * L: Total characters in the input.
//V: Unique characters in the input (bounded by 26 for the English alphabet).
//E: Number of edges (dependencies) in the graph, bounded by T * L in the worst case.
//In practical scenarios, since U and E are much smaller than T * L, the overall complexity is dominated by O(T * L).

//SC = O(V+ E)
class AlienDictionary {
    fun alienOrder(words: List<String>): String {
        val graph: HashMap<Char, HashSet<Char>> = hashMapOf()
        words.forEach { word ->
            word.forEach {chr ->
                graph.putIfAbsent(chr, hashSetOf())
            }
        }// TC = O(T * L), T is total words, L is average of word length

        var prev = words[0]
        // drive order from adjacent words
        for (i in 1 until words.size) {
            val cur = words[i]
            for (j in 0 until minOf(prev.length, cur.length)) {
                // ignore duplicates
                if (prev[j] != cur[j]) {
                    graph[prev[j]]?.add(cur[j])
                    break
                }
            }
            prev = cur
        }// TC = O(T * L),
        val sorted: List<Char>? = topoSort(graph)
        return sorted?.joinToString("") ?: ""
    }

    private fun topoSort(graph: HashMap<Char, HashSet<Char>>): List<Char>? {
        val res: ArrayList<Char> = arrayListOf()
        val queue: PriorityQueue<Char> = PriorityQueue()
        val indegree: MutableMap<Char, Int> = findInDegree(graph)
        indegree.entries.forEach { entry ->
            if (entry.value == 0) {
                queue.add(entry.key)
            }
        }

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            res.add(node)
            for (neighbor in graph[node]!!) {
                indegree[neighbor] = indegree[neighbor]?.minus(1) ?: 0
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }

        indegree.values.forEach {
            if (it != 0) {
                return null
            }
        }
        return res
    }

    private fun <T> findInDegree(graph: java.util.HashMap<T, HashSet<T>>): MutableMap<T, Int> {
        val indegree: HashMap<T, Int> = HashMap()
        graph.keys.forEach { node ->
            indegree[node] = 0
        }
        graph.entries.forEach { entry ->
            for (node in entry.value) {
                indegree[node] = indegree[node]?.plus(1) ?: 0
            }
        }
        return indegree
    }// TC=O(V + E)
}

fun main() {
    val obj = AlienDictionary()
    println(obj.alienOrder(listOf("wrt", "wrf", "er", "ett", "rftt"))) //wertf
    println(obj.alienOrder(listOf("z", "x"))) // zx
    println(obj.alienOrder(listOf("z", "x", "z")))
    println(obj.alienOrder(listOf("za", "zb", "ca", "cb")))
    println(obj.alienOrder(listOf("z", "x", "a", "zb", "zx")))
}