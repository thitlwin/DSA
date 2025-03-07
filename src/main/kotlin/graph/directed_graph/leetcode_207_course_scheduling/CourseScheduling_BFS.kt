package graph.directed_graph.leetcode_207_course_scheduling

class CourseScheduling_BFS {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph: HashMap<Int, MutableList<Int>> = HashMap()
        for(node in 0 until numCourses) {
            graph[node] = arrayListOf()
        }
        for(edge in prerequisites) {
            graph[edge[1]]?.add(edge[0])
        }
        return topoSort(graph)
    }

    private fun topoSort(graph: HashMap<Int, MutableList<Int>>): Boolean {
        val resultList: MutableList<Int> = mutableListOf()
        val queue: ArrayDeque<Int> = ArrayDeque()
        val inDegree: MutableMap<Int, Int> = findInDegree(graph)
        inDegree.entries.forEach {entry ->
            if(entry.value == 0 ){
                queue.add(entry.key)
            }
        }

        while(queue.isNotEmpty()) {
            val node = queue.removeFirst()
            resultList.add(node)
            for(neighbor in graph[node]!!) {
                inDegree[neighbor] = inDegree[neighbor]?.minus(1) ?: 0
                if(inDegree[neighbor] == 0) {
                    queue.add(neighbor)
                }
            }
        }
        return resultList.size == graph.size
    }

    private fun findInDegree(graph: HashMap<Int, MutableList<Int>>): MutableMap<Int, Int> {
        val inDegree = HashMap<Int, Int>()
        graph.keys.forEach { node ->
            inDegree[node] = 0
        }

        graph.entries.forEach { entry ->
            for(node in entry.value) {
                inDegree[node] = inDegree[node]?.plus(1) ?: 0
            }
        }
        return inDegree
    }
}