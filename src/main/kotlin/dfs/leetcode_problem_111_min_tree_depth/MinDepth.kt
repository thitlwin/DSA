package dfs.leetcode_problem_111_min_tree_depth

import java.lang.Math.min

class MinDepth {
    fun minDepth(root: TreeNode?): Int {
        root ?: return 0
        if(root.left == null)
            return 1 + minDepth(root.right)
        if(root.right == null)
            return 1 + minDepth(root.left)
        return min(minDepth(root.left), minDepth(root.right)) + 1
    }
}

fun main() {
    val node1 = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)
    val node8 = TreeNode(8)
    val node9 = TreeNode(9)
    val node10 = TreeNode(10)

    node2.apply {
        left = node3
        right = node4.apply {
            left = node5
            right = node6
        }
    }
    val obj = MinDepth()
//    println(obj.minDepth(node2))
    node7.apply { right = node8.apply { right = node9.apply { right = node10 } } }
    println(obj.minDepth(node7))
}