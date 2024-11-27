package dfs.binary_search_tree.leetcode_problem_701_insert_to_bst

import dfs.binary_search_tree.TreeNode


class InsertIntoBST {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        if (`val` < root.`val`) {
            root.left = insertIntoBST(root.left, `val`)
        } else if (`val` > root.`val`) {
            root.right = insertIntoBST(root.right, `val`)
        }
        return root
    }

}

fun main() {
    val obj = InsertIntoBST()
    val root = TreeNode(40).apply {
        left = TreeNode(20).apply {
            left = TreeNode(10)
            right = TreeNode(30)
        }
        right = TreeNode(60).apply {
            left = TreeNode(50)
            right = TreeNode(70)
        }
    }
    val res = obj.insertIntoBST(root, 25)
    println(res)
}