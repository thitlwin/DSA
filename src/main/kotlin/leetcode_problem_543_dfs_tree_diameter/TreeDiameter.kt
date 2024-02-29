package leetcode_problem_543_dfs_tree_diameter

import kotlin.math.max

class TreeDiameter {
    private var maxDiameter = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return maxDiameter
    }

    private fun dfs(root: TreeNode?): Int {
        root ?: return 0
        val leftHeight = dfs(root.left)
        val rightHeight = dfs(root.right)
        maxDiameter = max(maxDiameter, leftHeight + rightHeight)
        return 1 + max(leftHeight, rightHeight)
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
//    node1.apply {
//        left = node2.apply {
//            left = node4
//            right = node5
//        }
//        right = node3
//    }

    node1.apply {
        left = node2.apply {
            left = node4.apply {
                left = node6
                right = node7
            }
            right = node5.apply {
                left = node8.apply { left = node10 }
                right = node9
            }
        }
        right = node3
    }

    val obj = TreeDiameter()
    println(obj.diameterOfBinaryTree(node1))
}