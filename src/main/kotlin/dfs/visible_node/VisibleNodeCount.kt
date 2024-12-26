package dfs.visible_node

import dfs.Node
import kotlin.math.max

// Same as LeetCode Problem 1448. Count Good Nodes in Binary Tree
class VisibleNodeCount {
    fun visibleTreeNode(root: Node<Int>): Int {
        return dfs(root, Int.MIN_VALUE)
    }

    private fun dfs(root: Node<Int>?, max: Int): Int {
        if (root == null) return 0
        var total = 0
        var maxSoFar = max
        if (root.`val` >= maxSoFar) {
            total++
            maxSoFar = root.`val`
        }
        total += dfs(root.left, maxSoFar)
        total += dfs(root.right, maxSoFar)
        return total
    }
}

fun main() {
    val obj = VisibleNodeCount()
//    val node3 = Node(3, null, null)
//    val node8 = Node(8, null, null)
//    val node6 = Node(6, null, null)
//    val node4 = Node(4, left = node3, right = node8)
//    val root = Node(5, left = node4, right = node6)
//    println(obj.visibleTreeNode(root))// 3

//    val nodeMinus50 = Node(-50, null, null)
//    val nodeMinus500 = Node(-500, null, nodeMinus50)
//    val root = Node(-100, null, nodeMinus500)
//    println(obj.visibleTreeNode(root)) // 2

//    val node5 = Node(5)
//    val node1_2 = Node(1)
//    val node4 = Node(4).apply {
//        left = node1_2
//        right = node5
//    }
//    val node3 = Node(3)
//    val node1_1 = Node(1).apply {
//        left = node3
//    }
//    val root = Node(3).apply {
//        left = node1_1
//        right = node4
//    }

    val root = Node(5)
    val node4 = Node(4).apply {
        left = Node(3)
        right = Node(7)
    }
    val node8 = Node(8).apply {
        left = Node(10)
        right = Node(2)
    }
    root.apply {
        left = node4
        right = node8
    }
    println(obj.visibleTreeNode(root))
}