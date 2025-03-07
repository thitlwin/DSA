package graph.directed_graph.leetcode_207_course_scheduling

class CourseScheduling_DFS {
    enum class State {
        TO_VISIT,
        VISITING,
        VISITED
    }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph: HashMap<Int, MutableList<Int>> = buildGraph(prerequisites)
        val states = Array(numCourses) {
            State.TO_VISIT
        }
        // dfs on each node
        for (i in 0 until numCourses) {
            if (!dfs(i, states, graph)) {
                return false
            }
        }
        return true
    }

    private fun buildGraph(prerequisites: Array<IntArray>): java.util.HashMap<Int, MutableList<Int>> {
        val graph: HashMap<Int, MutableList<Int>> = HashMap(prerequisites.size)
        for (dependency in prerequisites) {
            graph.computeIfAbsent(dependency[0]) {
                mutableListOf()
            }.add(dependency[1])
        }
        return graph
    }

    private fun dfs(
        start: Int,
        states: Array<State>,
        graph: java.util.HashMap<Int, MutableList<Int>>
    ): Boolean {
        // mark self as visiting
        states[start] = State.VISITING
        if (graph[start] != null) {
            for (neighbor in graph[start]!!) {
                // ignore visited nodes
                if (states[neighbor] == State.VISITED) {
                    continue
                }
                // revisiting a visiting node, Cycle!
                if (states[neighbor] == State.VISITING){
                    return false
                };
                // recursively visit neighbors
                // if a neighbor found a cycle, we return false right away
                if (!dfs(neighbor, states, graph)) {
                    return false
                }
            }
        }

        // mark self as visited
        states[start] = State.VISITED
        // if we have gotten this far, our neighbors haven't found any cycle
        return true
    }
}

fun main() {
    val obj = CourseScheduling_DFS()
//    println(obj.canFinish(2, arrayOf(intArrayOf(1,0))))
    println(obj.canFinish(2, arrayOf(intArrayOf(1,0), intArrayOf(0,1))))
}