package dfs.binary_search_tree.leetcode_problem_98_valid_bst

class ValidBST_Algo {
    fun isValidBST(root: TreeNode?): Boolean {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }

    private fun dfs(root: TreeNode?, minValue: Long, maxValue: Long): Boolean {
        if(root == null) return true
        if (!(root.`val` > minValue && root.`val` < maxValue)){
            return false
        }
        return dfs(root.left, minValue, root.`val`.toLong()) && dfs(root.right, root.`val`.toLong(), maxValue)
    }
}

fun main() {
    val obj = ValidBST_Algo()
    val root = TreeNode(6).apply{
        left = TreeNode(4).apply {
            left = TreeNode(3)
            right = TreeNode(5)
        }
        right = TreeNode(8)
    }
    println(obj.isValidBST(root))
}