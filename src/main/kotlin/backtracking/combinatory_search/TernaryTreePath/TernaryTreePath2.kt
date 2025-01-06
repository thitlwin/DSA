package backtracking.combinatory_search.TernaryTreePath

import backtracking.combinatory_search.Node

class TernaryTreePath2 {
    //    val resList = mutableListOf<String>()
    fun ternaryTreePaths(root: Node<Int>): List<String> {
        return dfs(root, path = arrayListOf(), resList = mutableListOf<String>())
    }

    private fun dfs(root: Node<Int>, path: MutableList<String>, resList: MutableList<String>): List<String> {
        if (root.children.isEmpty()) {
            path.add(root.`val`.toString())
            resList.add(path.joinToString("->"))
            return resList
        }

        path.add(root.`val`.toString())
        for (child in root.children) {
            dfs(child, path = path, resList)
            path.removeLast()
        }
        return resList
    }
}

fun main() {
    val obj = TernaryTreePath2()

    val node2 = Node(2).apply {
        children.add(Node(3))
    }
    val node4 = Node(4).apply {
        children.addAll(listOf(Node(7), Node(8)))
    }
    val node6 = Node(6)

    val root = Node(1).apply {
        this.children.addAll(listOf(node2, node4, node6))
    }

    val res = obj.ternaryTreePaths(root)
    println(res.toString())
}