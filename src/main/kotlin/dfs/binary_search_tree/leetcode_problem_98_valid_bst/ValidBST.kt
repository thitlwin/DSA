package dfs.binary_search_tree.leetcode_problem_98_valid_bst

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class ValidBST {
    private var prevValue: Int? = null
    fun isValidBST(root: TreeNode?): Boolean {
        return dfs(root)
    }

    private fun dfs(node: TreeNode?): Boolean {
        if (node == null) return true
        if (!dfs(node.left)) return false
        if (prevValue != null && prevValue!! >= node.`val`) {
            return false
        }
        prevValue = node.`val`
        if (!dfs(node.right)) {
            return false
        }
        return true
    }
}