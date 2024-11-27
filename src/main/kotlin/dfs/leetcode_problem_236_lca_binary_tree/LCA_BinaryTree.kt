package dfs.leetcode_problem_236_lca_binary_tree

import dfs.binary_search_tree.leetcode_problem_235_BST_LCA.TreeNode

class LCA_BinaryTree {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        root ?: return null

        if (root == p || root == q)
            return root

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left != null && right != null)
            return root
        if (left != null)
            return left
        if (right != null)
            return right

        return null
    }
}

fun main() {
    val obj = LCA_BinaryTree()
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node1 = TreeNode(1).apply {
        left = node2.apply {
            left = node4
            right = node5.apply {
                left = node6
            }
        }
        right = node3
    }
    val res = obj.lowestCommonAncestor(node1, node3, node6)
    println(res?.`val`)
}