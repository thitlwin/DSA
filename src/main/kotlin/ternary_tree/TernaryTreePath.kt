package ternary_tree

data class Node<T>(val `val`: T) {
    val children = ArrayList<Node<T>>()
}

class TernaryTreePath {
    fun ternaryTreePaths(root: Node<Int>): List<String> {
        val result = ArrayList<String>()
        dfs(root, arrayListOf(), result)
        return result
    }

    private fun dfs(root: Node<Int>, path: ArrayList<Int>, result: ArrayList<String>) {
        if (root.children.isEmpty()) {
            path.add(root.`val`)
            result.add(path.joinToString("->"))
            path.removeLast()
            return
        }

        for (child in root.children) {
            path.add(root.`val`)
            dfs(child, path, result)
            path.removeLast()
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
    val node6 = Node(6)
    val node7 = Node(7)

    node1.apply {
        children.add(node2)
        children.add(node5)
        children.add(node6)
    }

    node2.apply {
        children.add(node3)
        children.add(node4)
        children.add(node7)
    }

    println(obj.ternaryTreePaths(node1))
}