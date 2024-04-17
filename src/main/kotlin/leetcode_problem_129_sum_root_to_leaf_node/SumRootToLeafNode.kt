package leetcode_problem_129_sum_root_to_leaf_node

import com.sun.source.tree.Tree
import kotlin.text.StringBuilder

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class SumRootToLeafNode {

    fun sumNumbers(root: TreeNode?): Int {
        return dfs(root, 0)
    }

    private fun dfs(root: TreeNode?, total: Int): Int {
        var sum = total
        if (root == null)
            return 0
        sum = sum * 10 + root.`val`
        if (root.left == null && root.right == null) {
            return sum
        }
        return dfs(root.left, sum) + dfs(root.right, sum)
    }
}

fun main() {
    val obj = SumRootToLeafNode()
//    val root = TreeNode(1).apply {
//        left = TreeNode(2)
//        right = TreeNode(3)
//    }
    val root = TreeNode(4).apply {
        left = TreeNode(9).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        }
        right = TreeNode(0)
    }
    println(obj.sumNumbers(root))
}