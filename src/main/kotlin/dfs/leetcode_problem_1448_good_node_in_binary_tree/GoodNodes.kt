package dfs.leetcode_problem_1448_good_node_in_binary_tree

import dfs.Node
import kotlin.math.max

class GoodNodes {
    fun goodNodes(root: Node<Int>?): Int {
        return dfs(root, Int.MIN_VALUE)
    }

    private fun dfs(node: Node<Int>?, maxSoFar: Int): Int {
        node ?: return 0
        var result = 0
        if (node.`val` >= maxSoFar){
            result++
        }
        result += dfs(node.left, max(node.`val`, maxSoFar))
        result += dfs(node.right, max(node.`val`, maxSoFar))
        return result
    }
}

fun main() {
    val obj = GoodNodes()
    val node3 = Node(3).apply {
        left = Node(1).apply {
            left = Node(3)
        }
        right = Node(4).apply {
            left = Node(1)
            right = Node(5)
        }
    }
    val res = obj.goodNodes(node3)
    println(res)
}