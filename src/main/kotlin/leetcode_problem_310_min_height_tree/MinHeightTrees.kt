package leetcode_problem_310_min_height_tree

import java.util.LinkedList

class MinHeightTrees {
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        val minHeightTrees = ArrayList<Int>()
        // base case : when there's only one node, return its as the root
        if (n == 1) {
            minHeightTrees.add(0)
            return minHeightTrees
        }

        // Initialize the adjacency list
        val adjacencyList = Array(n) { ArrayList<Int>() }

        val degrees = IntArray(n)

        for (edge in edges) {
            val nodeA = edge[0]
            val nodeB = edge[1]
            adjacencyList[nodeA].add(nodeB)
            adjacencyList[nodeB].add(nodeA)

            degrees[nodeA]++
            degrees[nodeB]++
        }

        val leavesQueue = LinkedList<Int>()
        for (i in 0 until n) {
            if (degrees[i] == 1) {
                leavesQueue.offer(i)
            }
        }

        while (!leavesQueue.isEmpty()) {
            minHeightTrees.clear()

            // number of leaves at the current level
            val leavesCount = leavesQueue.size
            for (i in 0 until leavesCount) {
                val leafNode = leavesQueue.poll()
                minHeightTrees.add(leafNode)

                for (neighbor in adjacencyList[leafNode]) {
                    degrees[neighbor]--
                    if (degrees[neighbor] == 1) {
                        leavesQueue.offer(neighbor)
                    }
                }
            }
        }
        return minHeightTrees
    }
}