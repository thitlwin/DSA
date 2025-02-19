package graph.directed_graph
// TC  = SC = O(V + E)

class SequenceReconstructing {
    fun sequenceReconstruction(original: List<Int>, seqs: List<List<Int>>): Boolean {
        val n = original.size
        val graph: MutableMap<Int, MutableSet<Int>> = HashMap()
        for (i in 1..n) {
            graph[i] = HashSet()
        }
        for (seq in seqs) {
            for (i in 0 until seq.size - 1) {
                val earlyNum = seq[i]
                val lateNumber = seq[i + 1]
                if (!graph[earlyNum]!!.contains(lateNumber)) {
                    graph[earlyNum]!!.add(lateNumber)// TC = O(1)
                }
            }
        }// TC = O(E) - process total number of edges
        return topoSort(graph, original)
    }

    private fun <T> topoSort(graph: MutableMap<T, MutableSet<T>>, original: List<T>): Boolean {
        val reconstructed: ArrayList<T> = arrayListOf()
        val queue: ArrayDeque<T> = ArrayDeque()
        val inDegree: MutableMap<T, Int> = findInDegree(graph)
        inDegree.entries.forEach { entry ->
            if (entry.value == 0) {
                queue.add(entry.key)
            }
        }

        while (queue.isNotEmpty()) {
            if (queue.size > 1) {
                return false
            }
            val node = queue.removeFirst() // O(V)
            reconstructed.add(node)
            for (neighbor in graph[node]!!) { // TC = O(E)
                inDegree[neighbor] = inDegree[neighbor]!!.minus(1)
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor) // O(V)
                }
            }
        }
        return original == reconstructed // O(V)
    }

    private fun <T> findInDegree(graph: MutableMap<T, MutableSet<T>>): MutableMap<T, Int> {
        val indegree: MutableMap<T, Int> = mutableMapOf()
        graph.keys.forEach { key ->
            indegree[key] = 0
        } // TC = O(V)
        graph.entries.forEach { entry ->
            entry.value.forEach {
                indegree[it] = indegree[it]!!.plus(1)
            }
        }// TC = O(E)
        return indegree
    }// TC = O(V + E)
}

fun main() {
    val obj = SequenceReconstructing()
//    println(obj.sequenceReconstruction(listOf(1, 2, 3), listOf(listOf(1, 2)))) // false
//    println(obj.sequenceReconstruction(listOf(1, 2, 3), listOf(listOf(1, 2), listOf(1,3)))) // false
//    println(obj.sequenceReconstruction(listOf(1, 2, 3), listOf(listOf(1, 2), listOf(1,3), listOf(2,3)))) // true
    println(
        obj.sequenceReconstruction(
            listOf(4, 1, 5, 2, 6, 3),
            listOf(listOf(5, 2, 6, 3), listOf(4, 1, 5, 2))
        )
    ) // true
}