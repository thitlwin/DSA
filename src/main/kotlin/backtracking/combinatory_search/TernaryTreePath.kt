package backtracking.combinatory_search

class TernaryTreePath {
    fun ternaryTreePaths(root: Node<Int>): List<String> {
        val result = ArrayList<String>()
        dfs(root, ArrayList(), result)
        return result
    }

    private fun dfs(root: Node<Int>, path: ArrayList<String>, result: ArrayList<String>) {
        if (root.children.size == 0) {
            path.add(root.`val`.toString())
            result.add(path.joinToString("->"))
            path.removeAt(path.size - 1) // remove last
            return
        }
        for (child in root.children) {
            path.add(root.`val`.toString())
            dfs(child, path, result)
            path.removeAt(path.size - 1)
        }
    }
}

fun main() {
    val obj = TernaryTreePath()
    val node1 = Node(1)
    val node2 = Node(2)
    val node3 = Node(3)
    val node4 = Node(4)
    val node5 = Node(5)
    node1.children.addAll(listOf(node2, node3, node4))
    node2.children.add(node5)
    val res = obj.ternaryTreePaths(node1)
    println(res.toString())
}