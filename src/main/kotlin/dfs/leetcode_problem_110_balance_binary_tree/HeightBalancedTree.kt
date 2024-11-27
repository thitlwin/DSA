package dfs.leetcode_problem_110_balance_binary_tree

import kotlin.math.abs

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class HeightBalancedTree {
    fun isBalanced(root: TreeNode?): Boolean {
        return height(root) != -1
    }

    // if(unbalanced) return -1 else return height
    private fun height(root: TreeNode?): Int {
        root ?: return 0
        val leftHeight = height(root.left)
        if (leftHeight == -1) return -1
        val rightHeight = height(root.right)
        if (rightHeight == -1) return -1
        if (abs(leftHeight - rightHeight) > 1) return -1
        return 1 + maxOf(leftHeight, rightHeight)
    }
}

fun main() {
    val one = TreeNode(1)
    val two = TreeNode(2)
    val three = TreeNode(3)
    val four = TreeNode(4)
    val five = TreeNode(5)
    val six = TreeNode(6)
    val seven = TreeNode(7)

    one.left = two
    one.right = three

    two.left = four
    three.right = five

    four.left = six
    five.right = seven

    val obj = HeightBalancedTree()
    println(obj.isBalanced(one))
}