package dfs.leetcode_problem_110_balance_binary_tree

import kotlin.math.abs
//This solution does not cover all edge cases
//[1,2,2,3,null,null,3,4,null,null,4]
class IsBalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        root ?: return true
        return abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right)
    }

    fun depth(root: TreeNode?): Int {
        root ?: return  0
        return dfs(root) - 1
    }

    private fun dfs(root: TreeNode?): Int {
        root ?: return 0
        return maxOf(dfs(root.left), dfs(root.right)) + 1
    }
}

fun main() {
    val obj = IsBalancedBinaryTree()
    val root = TreeNode(1).apply {
        right = TreeNode(2).apply {
            right = TreeNode(3)
        }
    }
    println(obj.isBalanced(root))
    println(obj.depth(root))
}