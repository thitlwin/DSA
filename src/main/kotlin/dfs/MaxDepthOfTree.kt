package dfs

class MaxDepthOfTree {
    fun depthOfTree(node: Node<Int>?): Int {
        if (node == null)
            return 0
        return dfs(node) - 1
    }

    private fun dfs(node: Node<Int>?): Int {
        if (node == null)
            return 0
        return maxOf(dfs(node.left), dfs(node.right)) + 1
    }
}

fun main() {
    val obj = MaxDepthOfTree()
    val tree = Node(1).apply {
        left = Node(2)
        right = Node(3).apply {
            left = Node(4)
            right = Node(5)
        }
    }
    println(obj.depthOfTree(tree))
}