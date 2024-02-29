package dfs.visible_node

import kotlin.math.max
// Same as LeetCode Problem 1448. Count Good Nodes in Binary Tree
class VisibleNodeCount {
    fun visibleTreeNode(root: Node<Int>): Int {
        return dfs(root, Int.MIN_VALUE)
    }

    private fun dfs(root: Node<Int>?, maxSoFar: Int): Int {
        if (root == null) return 0
        var total = 0
        if (root.`val` >= maxSoFar) {
            total++
        }
        total += dfs(root.left, max(root.`val`, maxSoFar))
        total += dfs(root.right, max(root.`val`, maxSoFar))
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

    val node5 = Node(5, null, null)
    val node1_2 = Node(1, null, null)
    val node4 = Node(4, node1_2, node5)
    val node3 = Node(3, null, null)
    val node1_1 = Node(1, left = node3, null)
    val root = Node(3, left = node1_1, node4) //4
    println(obj.visibleTreeNode(root))
}