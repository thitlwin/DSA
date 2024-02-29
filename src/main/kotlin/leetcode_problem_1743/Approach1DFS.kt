package leetcode_problem_1743

class Approach1DFS {
    private val graph = mutableMapOf<Int, MutableList<Int>>()
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        for (pair in adjacentPairs) {
            val x = pair[0]
            val y = pair[1]
            if (!graph.containsKey(x)) {
                graph[x] = arrayListOf()
            }
            if (!graph.containsKey(y)) {
                graph[y] = arrayListOf()
            }
            graph[x]?.add(y)
            graph[y]?.add(x)
        }

        var root = 0
        for (num in graph.keys) {
            if(graph[num]?.size == 1) {
                root = num
                break
            }
        }

        val ans = IntArray(graph.size)
        dfs(root, Integer.MAX_VALUE, ans, 0)
        return ans
    }

    private fun dfs(node: Int, prev: Int, ans: IntArray, i: Int) {
        ans[i] = node
        graph[node]?.let {
            for(neighbour in it) {
                if (neighbour != prev) {
                    dfs(neighbour, node, ans, i+1)
                }
            }
        }
    }
}