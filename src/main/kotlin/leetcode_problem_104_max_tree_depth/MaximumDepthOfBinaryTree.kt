package leetcode_problem_104_max_tree_depth

import java.lang.Integer.max

data class TreeNode(var `val`: Int){
    var left: TreeNode? = null
    var right: TreeNode? = null
}
class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        return dfs(root)
    }

    private fun dfs(root: TreeNode?): Int {
        root?:return 0
        return max(dfs(root.left), dfs(root.right)) + 1
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
    node1.apply {
        left = node2.apply {
            left = node4
            right = node5
        }
        right = node3
    }

    val obj = MaximumDepthOfBinaryTree()
    println(obj.maxDepth(node1))
}